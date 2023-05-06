package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.PhysiqueDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.CLIENT_MORAL_END_POINT;
import static com.notaris.soro.utils.Constantes.CLIENT_PHYSIQUE_END_POINT;

@Tag(name = CLIENT_PHYSIQUE_END_POINT, description = "l'API pour le client Physique")
public interface PhysiqueApi {

    @PostMapping(value = CLIENT_PHYSIQUE_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PhysiqueDTO> save(@RequestBody PhysiqueDTO dto);

    @GetMapping(value = CLIENT_PHYSIQUE_END_POINT+ "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PhysiqueDTO> findById(@PathVariable Integer id);

    @GetMapping(value = CLIENT_PHYSIQUE_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<PhysiqueDTO>> findAll();

    @GetMapping(value = CLIENT_PHYSIQUE_END_POINT+ "/{email}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PhysiqueDTO> findByEmail(@PathVariable String email);

    @GetMapping(value = CLIENT_PHYSIQUE_END_POINT+ "/{nom}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PhysiqueDTO findByNom(@PathVariable String nom);

    @DeleteMapping(value = CLIENT_MORAL_END_POINT+ "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity delete(@PathVariable Integer id);
}
