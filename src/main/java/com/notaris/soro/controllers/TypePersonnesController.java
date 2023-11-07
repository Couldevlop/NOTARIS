package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.TypePersonnesApi;
import com.notaris.soro.dto.admin.TypePersonnesDTO;
import com.notaris.soro.services.TypePersonnesService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TypePersonnesController implements TypePersonnesApi {
    private final TypePersonnesService typePersonnesService;

    public TypePersonnesController(TypePersonnesService typePersonnesService) {
        this.typePersonnesService = typePersonnesService;
    }

    @Override
    public ResponseEntity<TypePersonnesDTO> save(TypePersonnesDTO dto) {
        return ResponseEntity.ok(typePersonnesService.save(dto));
    }

    @Override
    public ResponseEntity<TypePersonnesDTO> findById(Integer id) {
        return ResponseEntity.ok(typePersonnesService.findById(id));
    }

    @Override
    public ResponseEntity<List<TypePersonnesDTO>> findAll() {
        return ResponseEntity.ok(typePersonnesService.findAll());
    }

    @Override
    public ResponseEntity <TypePersonnesDTO> update(Integer id, TypePersonnesDTO dto) {
        return ResponseEntity.ok(typePersonnesService.update(id, dto));
    }

    @Override
    public ResponseEntity delete(Integer id) {
        typePersonnesService.delete(id);
        return ResponseEntity.ok().build();
    }
}
