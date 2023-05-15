package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.NatureSocieteDTO;
import com.notaris.soro.dto.TypeSocieteDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.SOCIETE_CONSTITUTION_END_POINT;
import static com.notaris.soro.utils.Constantes.SOCIETE_MODIFICATION_END_POINT;

@Tag(name = SOCIETE_MODIFICATION_END_POINT, description = "l'API pour la modification d'une société")
public interface TypeSocieteApi {
    @PostMapping(value = SOCIETE_MODIFICATION_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TypeSocieteDTO> save(@RequestBody TypeSocieteDTO dto);

    @GetMapping(value = SOCIETE_MODIFICATION_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TypeSocieteDTO> findById(@PathVariable Integer id);

    @GetMapping(value = SOCIETE_MODIFICATION_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TypeSocieteDTO>> findAll();

    @GetMapping(value = SOCIETE_MODIFICATION_END_POINT+ "/libelle/{libelle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TypeSocieteDTO> findByLibelle(String intitule);

    @PutMapping(value = SOCIETE_MODIFICATION_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TypeSocieteDTO> update(@PathVariable Integer id, @RequestBody TypeSocieteDTO dto);

    @DeleteMapping(value = SOCIETE_MODIFICATION_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);
}
