package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.PaysApi;
import com.notaris.soro.dto.admin.PaysDTO;
import com.notaris.soro.services.PaysService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PaysController implements PaysApi {
    private final PaysService paysService;

    public PaysController(PaysService paysService) {
        this.paysService = paysService;
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<PaysDTO> save(PaysDTO dto) {
        return ResponseEntity.ok(paysService.save(dto));
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<PaysDTO> findById(Integer id) {
        return ResponseEntity.ok(paysService.findById(id));
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<PaysDTO>> findAll() {
        return ResponseEntity.ok(paysService.findAll());
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<PaysDTO> update(Integer id, PaysDTO dto) {
        return ResponseEntity.ok(paysService.update(id, dto));
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity delete(Integer id) {
        paysService.delete(id);
        return ResponseEntity.ok().build();
    }
}
