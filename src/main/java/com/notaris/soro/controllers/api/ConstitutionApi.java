package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.CreationDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.CLIENT_PHYSIQUE_END_POINT;
import static com.notaris.soro.utils.Constantes.SOCIETE_CONSTITUTION_END_POINT;

@Tag(name = SOCIETE_CONSTITUTION_END_POINT, description = "l'API pour la constitution d'une sociéte")
public interface ConstitutionApi {

    @PostMapping(value = SOCIETE_CONSTITUTION_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CreationDTO> save(@RequestBody CreationDTO creationDTO);

    @GetMapping(value = SOCIETE_CONSTITUTION_END_POINT+"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CreationDTO> findById(@PathVariable("id") Integer id);

    @GetMapping(value = SOCIETE_CONSTITUTION_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CreationDTO>> findAll();

    @PutMapping(value =SOCIETE_CONSTITUTION_END_POINT+ "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CreationDTO> update(@PathVariable Integer id, @RequestBody CreationDTO dto);
    @GetMapping(value = SOCIETE_CONSTITUTION_END_POINT+"/intitule/{intitule}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CreationDTO> findByIntitule(@PathVariable("intitule") String intitule);

    @DeleteMapping(value = SOCIETE_CONSTITUTION_END_POINT+"/{id1}")
    ResponseEntity delete(@PathVariable("id") Integer id1);

}
