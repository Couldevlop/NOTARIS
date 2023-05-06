package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.TypeDocumentApi;
import com.notaris.soro.dto.TypeDocumentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeDocumentController implements TypeDocumentApi {
    @Override
    public ResponseEntity<TypeDocumentDTO> save(TypeDocumentDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<TypeDocumentDTO> findById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<TypeDocumentDTO>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity delete(Integer id) {
        return null;
    }
}
