package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.MoralApi;
import com.notaris.soro.dto.MoralDTO;
import com.notaris.soro.services.MoralService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8086")
public class MoralController implements MoralApi {

    private final MoralService moralService;

    public MoralController(MoralService moralService) {
        this.moralService = moralService;
    }

    @Override
    public ResponseEntity<MoralDTO> save(MoralDTO dto) {
        return ResponseEntity.ok(moralService.save(dto));
    }

    @Override
    public ResponseEntity<MoralDTO> findById(Integer id) {
        return ResponseEntity.ok(moralService.findById(id));
    }

    @Override
    public ResponseEntity<List<MoralDTO>> findAll() {
        return ResponseEntity.ok(moralService.findAll());
    }

    @Override
    public ResponseEntity<MoralDTO> findByEmail(String email) {
        return ResponseEntity.ok(moralService.findByEmail(email));
    }

    @Override
    public ResponseEntity<MoralDTO> findByNom(String nom) {
        return ResponseEntity.ok(moralService.findByNom(nom));
    }

    @Override
    public ResponseEntity delete(Integer id) {
        moralService.delete(id);
        return ResponseEntity.ok().build();
    }
}
