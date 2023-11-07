package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.ConstitutionApi;
import com.notaris.soro.dto.CreationDTO;
import com.notaris.soro.services.ConstitutionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize(" hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ConstitutionController implements ConstitutionApi {
    private final ConstitutionService constitutionService;

    public ConstitutionController(ConstitutionService constitutionService) {
        this.constitutionService = constitutionService;
    }


    @Override
    public ResponseEntity<CreationDTO> save(CreationDTO creationDTO) {
        return ResponseEntity.ok(constitutionService.save(creationDTO));
    }

    @Override
    public ResponseEntity<CreationDTO> findById(Integer id) {
        return ResponseEntity.ok(constitutionService.findById(id));
    }

    @Override
    public ResponseEntity<List<CreationDTO>> findAll() {
        return ResponseEntity.ok(constitutionService.findAll());
    }

    @Override
    public ResponseEntity<CreationDTO> update(Integer id, CreationDTO dto) {
        return ResponseEntity.ok(constitutionService.update(id, dto));
    }

    @Override
    public ResponseEntity<CreationDTO> findByIntitule(String intitule) {
        return ResponseEntity.ok(constitutionService.findByIntitule(intitule));
    }

    @Override
    public ResponseEntity delete(Integer id) {
        constitutionService.delete(id);
         return  ResponseEntity.ok().build();
    }
}
