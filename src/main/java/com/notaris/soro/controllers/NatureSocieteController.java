package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.NatureSocieteApi;
import com.notaris.soro.dto.NatureSocieteDTO;
import com.notaris.soro.services.NatureSocieteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8086")
public class NatureSocieteController implements NatureSocieteApi {
    private final NatureSocieteService natureSocieteService;

    public NatureSocieteController(NatureSocieteService natureSocieteService) {
        this.natureSocieteService = natureSocieteService;
    }

    @Override
    public ResponseEntity<NatureSocieteDTO> save(NatureSocieteDTO dto) {
        return ResponseEntity.ok(natureSocieteService.save(dto));
    }

    @Override
    public ResponseEntity<NatureSocieteDTO> findById(Integer id) {
        return ResponseEntity.ok(natureSocieteService.findById(id));
    }

    @Override
    public ResponseEntity<List<NatureSocieteDTO>> findAll() {
        return ResponseEntity.ok(natureSocieteService.findAll());
    }

    @Override
    public ResponseEntity<NatureSocieteDTO> findByLibelle(String libelle) {
        return ResponseEntity.ok(natureSocieteService.findByLibelle(libelle));
    }

    @Override
    public ResponseEntity<NatureSocieteDTO> update(Integer id, NatureSocieteDTO dto) {
        return ResponseEntity.ok(natureSocieteService.update(id, dto));
    }

    @Override
    public void delete(Integer id) {
        natureSocieteService.delete(id);
       ResponseEntity.ok().build();
    }
}
