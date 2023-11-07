package com.notaris.soro.controllers;


import com.notaris.soro.controllers.api.SuccessionApi;
import com.notaris.soro.dto.DocumentsSuccesionDTO;
import com.notaris.soro.dto.SuccessionDTO;
import com.notaris.soro.models.Documents;
import com.notaris.soro.services.SuccessionService;
import com.notaris.soro.services.impl.DocumentSuccessionServiceImpl;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@PreAuthorize(" hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class SuccessionController implements SuccessionApi {
    private final SuccessionService successionService;
    private final DocumentSuccessionServiceImpl service;

    public SuccessionController(SuccessionService successionService, DocumentSuccessionServiceImpl service) {
        this.successionService = successionService;
        this.service = service;
    }


    @Override
    public ResponseEntity<SuccessionDTO> save(SuccessionDTO dto) {
        return ResponseEntity.ok(successionService.save(dto));
    }

    @Override
    public ResponseEntity<DocumentsSuccesionDTO> saveWitFile(MultipartFile file, String intitule, String id, String typeDoc) {
        return ResponseEntity.ok(service.saveWitFile(file,intitule, id,typeDoc));
    }

    @Override
    public ResponseEntity<List<DocumentsSuccesionDTO>> findSuccessionByIdDossier(Integer id) {
        return ResponseEntity.ok(successionService.findSuccessionByIdDossier(id));
    }

    @Override
    public ResponseEntity<ByteArrayResource> downloadFile(Integer fileId) {
        if(fileId == null){

        }
        DocumentsSuccesionDTO doc = service.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(doc.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
                .body(new ByteArrayResource(doc.getData()));
    }

    @Override
    public ResponseEntity<SuccessionDTO> findById(Integer id) {
        return ResponseEntity.ok(successionService.findById(id));
    }

    @Override
    public ResponseEntity<List<SuccessionDTO>> findAll() {
        return ResponseEntity.ok(successionService.findAll());
    }

    @Override
    public ResponseEntity<SuccessionDTO> findByIntitule(String intituleSession) {
        return ResponseEntity.ok(successionService.findByIntitule(intituleSession));
    }

    @Override
    public ResponseEntity delete(Integer id1) {
        successionService.delete(id1);
        return ResponseEntity.ok().build();
    }
}
