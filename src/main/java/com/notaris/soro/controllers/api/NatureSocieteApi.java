package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.admin.NatureSocieteDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.*;

@Tag(name = NATURE_SOCIETE_END_POINT, description = "l'API pour la constitution d'une société")
public interface NatureSocieteApi {
    @PostMapping(value = NATURE_SOCIETE_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<NatureSocieteDTO> save(@RequestBody NatureSocieteDTO dto);

    @GetMapping(value = NATURE_SOCIETE_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<NatureSocieteDTO> findById(@PathVariable Integer id);

    @GetMapping(value = NATURE_SOCIETE_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<NatureSocieteDTO>> findAll();

    @GetMapping(value = NATURE_SOCIETE_END_POINT+ "/libelle/{libelle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<NatureSocieteDTO> findByLibelle(String intitule);

    @PutMapping(value = NATURE_SOCIETE_END_POINT+"/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<NatureSocieteDTO> update(@PathVariable Integer id, @RequestBody NatureSocieteDTO dto);

    @DeleteMapping(value = NATURE_SOCIETE_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);
}
