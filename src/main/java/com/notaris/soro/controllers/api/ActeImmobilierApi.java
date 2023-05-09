package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.notaris.soro.utils.Constantes.ACTE_IMMO_END_POINT;
import static com.notaris.soro.utils.Constantes.CLIENT_MORAL_END_POINT;

@Tag(name = ACTE_IMMO_END_POINT, description = "l'API pour l'initialisation du dossier acte immobilier")
public interface ActeImmobilierApi {
    @PostMapping(value = ACTE_IMMO_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ActeImmobilierDTO> save(@RequestBody ActeImmobilierDTO dto);

    @GetMapping(value = ACTE_IMMO_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ActeImmobilierDTO> findById(@PathVariable(value = "id") Integer id);

    @GetMapping(value = ACTE_IMMO_END_POINT+ "/documment/{iddossier}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<DocumentsDTO>> findActeImmoDocByIdDossier(@PathVariable(value = "iddossier") Integer iddossier);

    @GetMapping(value = ACTE_IMMO_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ActeImmobilierDTO>> findAll();

    @PutMapping(value = ACTE_IMMO_END_POINT+ "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ActeImmobilierDTO> save(@PathVariable(value = "id") Integer idDossier, @RequestPart MultipartFile file) throws IOException;

    @DeleteMapping(value = ACTE_IMMO_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity delete(@PathVariable Integer id);

}
