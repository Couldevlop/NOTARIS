package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.MoralApi;
import com.notaris.soro.dto.MoralDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class MoralController implements MoralApi {
    @Override
    public ResponseEntity<MoralDTO> save(MoralDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<MoralDTO> findById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<MoralDTO>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<MoralDTO> findByEmail(String email) {
        return null;
    }

    @Override
    public ResponseEntity<MoralDTO> findByNom(String nom) {
        return null;
    }

    @Override
    public ResponseEntity delete(Integer id) {
        return null;
    }
}
