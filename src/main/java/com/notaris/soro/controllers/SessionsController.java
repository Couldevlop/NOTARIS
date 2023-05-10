package com.notaris.soro.controllers;


import com.notaris.soro.controllers.api.SessionsApi;
import com.notaris.soro.dto.SessionsDTO;
import com.notaris.soro.services.SessionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SessionsController implements SessionsApi {
    private final SessionsService sessionsService;

    public SessionsController(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }


    @Override
    public ResponseEntity<SessionsDTO> save(SessionsDTO dto) {
        return ResponseEntity.ok(sessionsService.save(dto));
    }

    @Override
    public ResponseEntity<SessionsDTO> findById(Integer id) {
        return ResponseEntity.ok(sessionsService.findById(id));
    }

    @Override
    public ResponseEntity<List<SessionsDTO>> findAll() {
        return ResponseEntity.ok(sessionsService.findAll());
    }

    @Override
    public ResponseEntity<SessionsDTO> findByIntitule(String intituleSession) {
        return ResponseEntity.ok(sessionsService.findByIntitule(intituleSession));
    }

    @Override
    public ResponseEntity delete(Integer id1) {
        sessionsService.delete(id1);
        return ResponseEntity.ok().build();
    }
}
