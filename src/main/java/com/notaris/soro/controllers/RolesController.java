package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.PaysApi;
import com.notaris.soro.controllers.api.RoleApi;
import com.notaris.soro.dto.admin.PaysDTO;
import com.notaris.soro.dto.admin.RolesDTO;
import com.notaris.soro.services.RolesService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class RolesController implements RoleApi {
    private final RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }


    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<RolesDTO> save(RolesDTO dto) {
        return ResponseEntity.ok(rolesService.save(dto));
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<RolesDTO> findById(Integer id) {
        return ResponseEntity.ok(rolesService.findById(id));
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<RolesDTO>> findAll() {
        return ResponseEntity.ok(rolesService.findAll());
    }


    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity delete(Integer id) {
        rolesService.delete(id);
        return ResponseEntity.ok().build();
    }
}
