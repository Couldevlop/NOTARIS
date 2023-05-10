package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.CommunauteDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.LIQUIDATION_COMMUNAUTE_END_POINT;

@Tag(name = LIQUIDATION_COMMUNAUTE_END_POINT, description = "l'API pour la liquidation de communauté")
public interface CommunauteApi {

    @PostMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommunauteDTO> save(@RequestBody CommunauteDTO dto);

    @GetMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT+ "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommunauteDTO> findById(@PathVariable Integer id);

    @GetMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CommunauteDTO>> findAll();

    @GetMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT+ "/{intitule}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommunauteDTO> findByIntitule(@PathVariable String intitule);

    @DeleteMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT+ "/{id1}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity  delete(@PathVariable Integer id1);
}
