package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.TypeSuccessionsApi;
import com.notaris.soro.dto.admin.TypeSuccessionsDTO;
import com.notaris.soro.services.TypeSuccessionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TypeSuccessionsController implements TypeSuccessionsApi {
    private final TypeSuccessionsService typeSuccessionsService;

    public TypeSuccessionsController(TypeSuccessionsService typeSuccessionsService) {
        this.typeSuccessionsService = typeSuccessionsService;
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TypeSuccessionsDTO> save(TypeSuccessionsDTO dto) {
        return ResponseEntity.ok(typeSuccessionsService.save(dto));
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TypeSuccessionsDTO> findById(Integer id) {
        return ResponseEntity.ok(typeSuccessionsService.findById(id));
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<List<TypeSuccessionsDTO>> findAll() {
        return ResponseEntity.ok(typeSuccessionsService.findAll());
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<TypeSuccessionsDTO> update(Integer id, TypeSuccessionsDTO dto) {
        return ResponseEntity.ok(typeSuccessionsService.update(id, dto));
    }

    @Override
    @PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity delete(Integer id) {
        typeSuccessionsService.delete(id);
        return ResponseEntity.ok().build();
    }
}
