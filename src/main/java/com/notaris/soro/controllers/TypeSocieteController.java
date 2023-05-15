package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.TypeSocieteApi;
import com.notaris.soro.dto.TypeSocieteDTO;
import com.notaris.soro.services.TypeSocieteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8086")
public class TypeSocieteController implements TypeSocieteApi {
    private final TypeSocieteService typeSocieteService;

    public TypeSocieteController(TypeSocieteService typeSocieteService) {
        this.typeSocieteService = typeSocieteService;
    }

    @Override
    public ResponseEntity<TypeSocieteDTO> save(TypeSocieteDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<TypeSocieteDTO> findById(Integer id) {
        return ResponseEntity.ok(typeSocieteService.findById(id));
    }

    @Override
    public ResponseEntity<List<TypeSocieteDTO>> findAll() {
        return ResponseEntity.ok(typeSocieteService.findAll());
    }

    @Override
    public ResponseEntity<TypeSocieteDTO> findByLibelle(String libelle) {
        return ResponseEntity.ok(typeSocieteService.findByLibelle(libelle));
    }

    @Override
    public ResponseEntity<TypeSocieteDTO> update(Integer id, TypeSocieteDTO dto) {
        return ResponseEntity.ok(typeSocieteService.update(id, dto));
    }

    @Override
    public void delete(Integer id) {
        typeSocieteService.delete(id);
      ResponseEntity.ok().build();
    }
}
