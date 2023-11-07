package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.TypeSocieteDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.*;

@Tag(name = TYPE_SOCIETE_END_POINT, description = "l'API pour gerer  le type de société")
public interface TypeSocieteApi {
    @PostMapping(value = TYPE_SOCIETE_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TypeSocieteDTO> save(@RequestBody TypeSocieteDTO dto);

    @GetMapping(value = TYPE_SOCIETE_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TypeSocieteDTO> findById(@PathVariable Integer id);

    @GetMapping(value = TYPE_SOCIETE_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TypeSocieteDTO>> findAll();

    @GetMapping(value = TYPE_SOCIETE_END_POINT+ "/libelle/{libelle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TypeSocieteDTO> findByLibelle(String intitule);

    @PutMapping(value = TYPE_SOCIETE_END_POINT+ "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TypeSocieteDTO> update(@PathVariable Integer id, @RequestBody TypeSocieteDTO dto);

    @DeleteMapping(value = TYPE_SOCIETE_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable Integer id);

}
