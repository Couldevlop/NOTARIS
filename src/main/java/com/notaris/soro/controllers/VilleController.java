package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.VilleApi;
import com.notaris.soro.dto.admin.VilleDTO;
import com.notaris.soro.services.VilleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class VilleController implements VilleApi {
    private final VilleService villeService;

    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }


    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<VilleDTO> save(VilleDTO dto) {
        return ResponseEntity.ok(villeService.save(dto));
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<VilleDTO> findById(Integer id) {
        return ResponseEntity.ok(villeService.findById(id));
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<VilleDTO>> findAll() {
        return ResponseEntity.ok(villeService.findAll());
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<VilleDTO> update(Integer id, VilleDTO dto) {
        return ResponseEntity.ok(villeService.update(id, dto));
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity delete(Integer id) {
         villeService.delete(id);
         return ResponseEntity.ok().build();
    }
}
