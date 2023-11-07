package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.OuvertureCreditDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.CLIENT_BANQUE_END_POINT;
import static com.notaris.soro.utils.Constantes.OUVERTURE_CREDIT_END_POINT;

@Tag(name = OUVERTURE_CREDIT_END_POINT, description = "l'API pour l'ouverture de credit")
public interface OuvertureCreditApi {

    @PostMapping(value = OUVERTURE_CREDIT_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<OuvertureCreditDTO> save(@RequestBody OuvertureCreditDTO dto);

    @GetMapping(value = OUVERTURE_CREDIT_END_POINT+ "/{id}")
    ResponseEntity<OuvertureCreditDTO> findById(@PathVariable("id") Integer id);

    @GetMapping(value = OUVERTURE_CREDIT_END_POINT)
   ResponseEntity<List<OuvertureCreditDTO>> findAll();

    @DeleteMapping(value = OUVERTURE_CREDIT_END_POINT+ "/{id1}")
     ResponseEntity delete(@PathVariable("id") Integer id1);
}
