package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.PhysiqueApi;
import com.notaris.soro.dto.PhysiqueDTO;
import com.notaris.soro.services.PhysiqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhysiqueController implements PhysiqueApi {

    private final PhysiqueService physiqueService;

    public PhysiqueController(PhysiqueService physiqueService) {
        this.physiqueService = physiqueService;
    }

    @Override
    public ResponseEntity<PhysiqueDTO> save(PhysiqueDTO dto) {
        return ResponseEntity.ok(physiqueService.save(dto));
    }

    @Override
    public ResponseEntity<PhysiqueDTO> findById(Integer id) {
        return ResponseEntity.ok(physiqueService.findById(id));
    }

    @Override
    public ResponseEntity<List<PhysiqueDTO>> findAll() {
        return ResponseEntity.ok(physiqueService.findAll());
    }

    @Override
    public ResponseEntity<PhysiqueDTO> findByEmail(String email) {
        return ResponseEntity.ok(physiqueService.findByEmail(email));
    }

    @Override
    public ResponseEntity<PhysiqueDTO> findByNom(String nom) {
        return ResponseEntity.ok(physiqueService.findByNom(nom));
    }

    @Override
    public ResponseEntity delete(Integer id1) {
        physiqueService.delete(id1);
        return ResponseEntity.ok().build();
    }
}
