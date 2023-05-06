package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.TypeDocumentDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import static com.notaris.soro.utils.Constantes.TYPE_DOCUMENT_END_POINT;

@Tag(name = TYPE_DOCUMENT_END_POINT, description = "l'API pour le client Type de Document")
public interface TypeDocumentApi {
    @PostMapping(value = TYPE_DOCUMENT_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TypeDocumentDTO> save(@RequestBody TypeDocumentDTO dto);

    @GetMapping(value = TYPE_DOCUMENT_END_POINT+ "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TypeDocumentDTO> findById(@PathVariable Integer id);

    @GetMapping(value = TYPE_DOCUMENT_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TypeDocumentDTO>> findAll();

    @DeleteMapping(value = TYPE_DOCUMENT_END_POINT+ "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity delete(@PathVariable Integer id);

}
