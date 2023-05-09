package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.MoralDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import static com.notaris.soro.utils.Constantes.CLIENT_MORAL_END_POINT;

@Tag(name = CLIENT_MORAL_END_POINT, description = "l'API pour le client moral")
public interface MoralApi {
    @PostMapping(value = CLIENT_MORAL_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<MoralDTO> save(@RequestBody MoralDTO dto);

    @GetMapping(value = CLIENT_MORAL_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<MoralDTO> findById(@PathVariable Integer id);

    @GetMapping(value = CLIENT_MORAL_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<MoralDTO>> findAll();

    @GetMapping(value = CLIENT_MORAL_END_POINT+ "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<MoralDTO> findByEmail(@PathVariable String email);

    @GetMapping(value = CLIENT_MORAL_END_POINT+ "/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<MoralDTO> findByNom(@PathVariable String nom);

    @DeleteMapping(value = CLIENT_MORAL_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity delete(@PathVariable Integer id);
}
