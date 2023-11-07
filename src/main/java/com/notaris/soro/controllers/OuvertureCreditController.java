package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.OuvertureCreditApi;
import com.notaris.soro.dto.OuvertureCreditDTO;
import com.notaris.soro.services.OuvertureCreditService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize(" hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class OuvertureCreditController implements OuvertureCreditApi {
    private final OuvertureCreditService  ouvertureCreditService;

    public OuvertureCreditController(OuvertureCreditService ouvertureCreditService) {
        this.ouvertureCreditService = ouvertureCreditService;
    }

    @Override
    public ResponseEntity<OuvertureCreditDTO> save(OuvertureCreditDTO dto) {
        return ResponseEntity.ok(ouvertureCreditService.save(dto));
    }

    @Override
    public ResponseEntity<OuvertureCreditDTO> findById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<OuvertureCreditDTO>> findAll() {
        return ResponseEntity.ok(ouvertureCreditService.findAll());
    }

    @Override
    public ResponseEntity delete(Integer id) {
       ouvertureCreditService.delete(id);
       return ResponseEntity.ok().build();
    }
}
