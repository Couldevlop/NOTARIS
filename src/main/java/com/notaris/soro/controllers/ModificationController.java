package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.ModificationApi;
import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsModifSocieteDTO;
import com.notaris.soro.dto.ModificationDTO;
import com.notaris.soro.services.ModificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@PreAuthorize(" hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ModificationController implements ModificationApi {
    private final ModificationService modificationService;

    public ModificationController(ModificationService modificationService) {
        this.modificationService = modificationService;
    }


    @Override
    public ResponseEntity<ModificationDTO> save(ModificationDTO dto) {
        return ResponseEntity.ok(modificationService.save(dto));
    }

    @Override
    public ResponseEntity<ModificationDTO> findById(Integer id) {
        return ResponseEntity.ok(modificationService.findById(id));
    }

    @Override
    public ResponseEntity<List<ModificationDTO>> findAll() {
        return ResponseEntity.ok(modificationService.findAll());
    }

    @Override
    public ResponseEntity<ModificationDTO> update(Integer id, ModificationDTO dto) {
        return ResponseEntity.ok(modificationService.update(id, dto));
    }

 /*   @Override
    public ResponseEntity<ModificationDTO> save(Integer idDossier, MultipartFile file) throws IOException {
        return ResponseEntity.ok(modificationService.save(idDossier, file));
    }


    @Override
    public ResponseEntity<List<DocumentsModifSocieteDTO>> findActeModifScteDocByIddossier(Integer id1) {
        return ResponseEntity.ok(modificationService.findActeModifScteDocByIddossier(id1));
    }*/

    @Override
    public void delete(Integer id2) {
      modificationService.delete(id2);
      ResponseEntity.ok().build();
    }
}
