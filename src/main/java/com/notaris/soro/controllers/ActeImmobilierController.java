package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.ActeImmobilierApi;
import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.services.ActeImmoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActeImmobilierController implements ActeImmobilierApi {
    private final ActeImmoService acteImmoService;

    public ActeImmobilierController(ActeImmoService acteImmoService) {
        this.acteImmoService = acteImmoService;
    }

    @Override
    public ResponseEntity<ActeImmobilierDTO> save(ActeImmobilierDTO dto) {
        return ResponseEntity.ok(acteImmoService.save(dto));
    }

    @Override
    public ResponseEntity<ActeImmobilierDTO> findById(Integer id) {
        return ResponseEntity.ok(acteImmoService.findById(id));
    }

    @Override
    public ResponseEntity<List<ActeImmobilierDTO>> findAll() {
        return ResponseEntity.ok(acteImmoService.findAll());
    }

    @Override
    public ResponseEntity<DocumentsDTO> save(Integer idDossier, DocumentsDTO dto) {
        return ResponseEntity.ok(acteImmoService.save(idDossier,dto));
    }

    @Override
    public ResponseEntity delete(Integer id) {
        acteImmoService.delete(id);
        return  ResponseEntity.ok().build();
    }
}
