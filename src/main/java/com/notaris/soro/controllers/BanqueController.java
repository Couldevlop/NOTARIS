package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.BanqueApi;
import com.notaris.soro.dto.BanqueDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BanqueController implements BanqueApi {
    @Override
    public ResponseEntity<BanqueDTO> save(BanqueDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<BanqueDTO> findById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<BanqueDTO>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<BanqueDTO> findBySigle(String sigle) {
        return null;
    }

    @Override
    public ResponseEntity delete(Integer id) {
        return null;
    }
}
