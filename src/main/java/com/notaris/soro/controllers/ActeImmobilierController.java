package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.ActeImmobilierApi;
import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.services.ActeImmoService;
import com.notaris.soro.services.impl.DocumentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@PreAuthorize(" hasAnyRole('USER','MODERATOR','ADMIN')")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ActeImmobilierController implements ActeImmobilierApi {
    private final ActeImmoService acteImmoService;
    private final DocumentServiceImpl service;

    public ActeImmobilierController(ActeImmoService acteImmoService, DocumentServiceImpl service) {
        this.acteImmoService = acteImmoService;
        this.service = service;
    }

    @Override
    public ResponseEntity<ActeImmobilierDTO> save(ActeImmobilierDTO dto) {
        return ResponseEntity.ok(acteImmoService.save(dto));
    }

    @Override
    public ResponseEntity<DocumentsDTO> saveWitFile(MultipartFile file, String intitule, String id, String typeDoc) {
        return ResponseEntity.ok(service.saveWitFile(file,intitule, id,typeDoc));
    }

    @Override
    public ResponseEntity<ActeImmobilierDTO> findById(Integer id) {
        return ResponseEntity.ok(acteImmoService.findById(id));
    }

    @Override
    public ResponseEntity<List<DocumentsDTO>> findActeImmoDocByIdDossier(Integer iddossier) {
        return ResponseEntity.ok(acteImmoService.findActeImmoDocByIddossier(iddossier));
    }

    @Override
    public ResponseEntity<List<ActeImmobilierDTO>> findAll() {
        return ResponseEntity.ok(acteImmoService.findAll());
    }

    @Override
    public ResponseEntity<ActeImmobilierDTO> save(Integer idDossier, MultipartFile file ) throws IOException {
        return ResponseEntity.ok(acteImmoService.save(idDossier,file));
    }

    @Override
    public ResponseEntity delete(Integer id) {
        acteImmoService.delete(id);
        return  ResponseEntity.ok().build();
    }
}
