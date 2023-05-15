package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.CommunauteApi;
import com.notaris.soro.dto.CommunauteDTO;
import com.notaris.soro.services.CommunauteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8086")
public class CommunauteController implements CommunauteApi {
    private final CommunauteService communauteService;

    public CommunauteController(CommunauteService communauteService) {
        this.communauteService = communauteService;
    }


    @Override
    public ResponseEntity<CommunauteDTO> save(CommunauteDTO dto) {
        return ResponseEntity.ok(communauteService.save(dto));
    }

    @Override
    public ResponseEntity<CommunauteDTO> findById(Integer id) {
        return ResponseEntity.ok(communauteService.findById(id));
    }

    @Override
    public ResponseEntity<List<CommunauteDTO>> findAll() {
        return ResponseEntity.ok(communauteService.findAll());
    }

    @Override
    public ResponseEntity<CommunauteDTO> findByIntitule(String intitule) {
        return ResponseEntity.ok(communauteService.findByIntitule(intitule));
    }

    @Override
    public ResponseEntity delete(Integer id1) {
        communauteService.delete(id1);
        return ResponseEntity.ok().build();
    }
}
