package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.admin.PaysDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.PAYS_END_POINT;

@Tag(name = PAYS_END_POINT, description = "L'API pour gerer les pays")
public interface PaysApi {

    @PostMapping(value = PAYS_END_POINT)
    ResponseEntity<PaysDTO> save(@RequestBody PaysDTO dto);

    @GetMapping(value = PAYS_END_POINT+ "/{id}")
    ResponseEntity<PaysDTO> findById(@PathVariable("id") Integer id);

    @GetMapping(value = PAYS_END_POINT)
    ResponseEntity<List<PaysDTO>> findAll();

    @PutMapping(value = PAYS_END_POINT+ "/{id1}")
    ResponseEntity<PaysDTO> update(@PathVariable("id1") Integer id, @RequestBody PaysDTO dto);

    @DeleteMapping(value = PAYS_END_POINT+ "/{id2}")
    ResponseEntity delete(@PathVariable("id2") Integer id);
}
