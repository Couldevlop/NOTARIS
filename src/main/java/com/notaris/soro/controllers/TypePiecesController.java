package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.TypePiecesApi;
import com.notaris.soro.dto.admin.TypePiecesDTO;
import com.notaris.soro.services.TypePiecesService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TypePiecesController implements TypePiecesApi {

    private final TypePiecesService typePiecesService;

    public TypePiecesController(TypePiecesService typePiecesService) {
        this.typePiecesService = typePiecesService;
    }

    @Override
    public ResponseEntity<TypePiecesDTO> save(TypePiecesDTO dto) {
        return ResponseEntity.ok(typePiecesService.save(dto));
    }

    @Override
    public ResponseEntity<TypePiecesDTO> findById(Integer id) {
        return ResponseEntity.ok(typePiecesService.findById(id));
    }

    @Override
    public ResponseEntity<List<TypePiecesDTO>> findAll() {
        return ResponseEntity.ok(typePiecesService.findAll());
    }

    @Override
    public ResponseEntity<TypePiecesDTO> update(Integer id, TypePiecesDTO dto) {
        return ResponseEntity.ok(typePiecesService.update(id, dto));
    }

    @Override
    public ResponseEntity delete(Integer id) {
        typePiecesService.delete(id);
        return ResponseEntity.ok().build();
    }
}
