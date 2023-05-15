package com.notaris.soro.controllers;


import com.notaris.soro.controllers.api.SessionsApi;
import com.notaris.soro.dto.SucessionDTO;
import com.notaris.soro.services.SessionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8086")
public class SessionsController implements SessionsApi {
    private final SessionsService sessionsService;

    public SessionsController(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }


    @Override
    public ResponseEntity<SucessionDTO> save(SucessionDTO dto) {
        return ResponseEntity.ok(sessionsService.save(dto));
    }

    @Override
    public ResponseEntity<SucessionDTO> findById(Integer id) {
        return ResponseEntity.ok(sessionsService.findById(id));
    }

    @Override
    public ResponseEntity<List<SucessionDTO>> findAll() {
        return ResponseEntity.ok(sessionsService.findAll());
    }

    @Override
    public ResponseEntity<SucessionDTO> findByIntitule(String intituleSession) {
        return ResponseEntity.ok(sessionsService.findByIntitule(intituleSession));
    }

    @Override
    public ResponseEntity delete(Integer id1) {
        sessionsService.delete(id1);
        return ResponseEntity.ok().build();
    }
}
