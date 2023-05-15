package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.SucessionDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.LIQUIDATION_SESSION_END_POINT;

@Tag(name = LIQUIDATION_SESSION_END_POINT, description = "l'API pour la liquidation de session")
public interface SessionsApi {

    @PostMapping(value = LIQUIDATION_SESSION_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<SucessionDTO> save(@RequestBody SucessionDTO dto);

    @GetMapping(value = LIQUIDATION_SESSION_END_POINT+ "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<SucessionDTO> findById(@PathVariable Integer id);

    @GetMapping(value = LIQUIDATION_SESSION_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<SucessionDTO>> findAll();

    @GetMapping(value = LIQUIDATION_SESSION_END_POINT+ "/inititule/{intituleSession}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<SucessionDTO> findByIntitule(@PathVariable String intituleSession);

    @DeleteMapping(value = LIQUIDATION_SESSION_END_POINT+ "/{id1}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity  delete(@PathVariable Integer id1);
}
