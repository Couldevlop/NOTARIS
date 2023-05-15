package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.NatureSocieteDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.CLIENT_MORAL_END_POINT;
import static com.notaris.soro.utils.Constantes.SOCIETE_CONSTITUTION_END_POINT;

@Tag(name = SOCIETE_CONSTITUTION_END_POINT, description = "l'API pour la constitution d'une société")
public interface NatureSocieteApi {
    @PostMapping(value = SOCIETE_CONSTITUTION_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<NatureSocieteDTO> save(@RequestBody NatureSocieteDTO dto);

    @GetMapping(value = SOCIETE_CONSTITUTION_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<NatureSocieteDTO> findById(@PathVariable Integer id);

    @GetMapping(value = SOCIETE_CONSTITUTION_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<NatureSocieteDTO>> findAll();

    @GetMapping(value = SOCIETE_CONSTITUTION_END_POINT+ "/libelle/{libelle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<NatureSocieteDTO> findByLibelle(String intitule);

    @PutMapping(value = SOCIETE_CONSTITUTION_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<NatureSocieteDTO> update(@PathVariable Integer id, @RequestBody NatureSocieteDTO dto);

    @DeleteMapping(value = SOCIETE_CONSTITUTION_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);
}
