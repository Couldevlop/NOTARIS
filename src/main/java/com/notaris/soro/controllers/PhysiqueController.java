package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.PhysiqueApi;
import com.notaris.soro.dto.PhysiqueDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhysiqueController implements PhysiqueApi {
    @Override
    public ResponseEntity<PhysiqueDTO> save(PhysiqueDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<PhysiqueDTO> findById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<PhysiqueDTO>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<PhysiqueDTO> findByEmail(String email) {
        return null;
    }

    @Override
    public PhysiqueDTO findByNom(String nom) {
        return null;
    }

    @Override
    public ResponseEntity delete(Integer id) {
        return null;
    }
}
