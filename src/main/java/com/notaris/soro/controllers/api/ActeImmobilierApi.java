package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.ACTE_IMMO_END_POINT;
import static com.notaris.soro.utils.Constantes.CLIENT_MORAL_END_POINT;

@Tag(name = ACTE_IMMO_END_POINT, description = "l'API pour l'initialisation du dossier acte immobilier")
public interface ActeImmobilierApi {
    @PostMapping(value = ACTE_IMMO_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ActeImmobilierDTO> save(@RequestBody ActeImmobilierDTO dto);

    @GetMapping(value = ACTE_IMMO_END_POINT+ "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ActeImmobilierDTO> findById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = ACTE_IMMO_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ActeImmobilierDTO>> findAll();

    @PutMapping(value = ACTE_IMMO_END_POINT+ "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<DocumentsDTO> save(@PathVariable(value = "id") Integer idDossier, @RequestBody DocumentsDTO dto);

    @DeleteMapping(value = ACTE_IMMO_END_POINT+ "/{id}")
    ResponseEntity delete(@PathVariable Integer id);

}
