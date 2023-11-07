package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.BanqueApi;
import com.notaris.soro.dto.BanqueDTO;
import com.notaris.soro.services.BanqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@PreAuthorize(" hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class BanqueController implements BanqueApi {

    private final BanqueService banqueService;

    public BanqueController(BanqueService banqueService) {
        this.banqueService = banqueService;
    }

    @Override
    public ResponseEntity<BanqueDTO> save( MultipartFile file,BanqueDTO dto) throws IOException {
        return ResponseEntity.ok(banqueService.save(file,dto));
    }

    @Override
    public ResponseEntity<BanqueDTO> findById(Integer id) {
        return ResponseEntity.ok(banqueService.findById(id));
    }

    @Override
    public ResponseEntity<List<BanqueDTO>> findAll() {
        return ResponseEntity.ok(banqueService.findAll());
    }

    @Override
    public ResponseEntity<BanqueDTO> findBySigle(String sigle) {
        return ResponseEntity.ok(banqueService.findBySigle(sigle));
    }

    @Override
    public ResponseEntity delete(Integer id) {
        banqueService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<BanqueDTO> create(BanqueDTO dto) {
        return ResponseEntity.ok(banqueService.create(dto));
    }
}
