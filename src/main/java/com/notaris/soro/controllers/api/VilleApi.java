package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.admin.VilleDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.VILLE_END_POINT;

@Tag(name = VILLE_END_POINT, description = "L'API pour gerer les villes")
public interface VilleApi {
    @PostMapping(value = VILLE_END_POINT)
    ResponseEntity<VilleDTO> save(@RequestBody VilleDTO dto);

    @GetMapping(value = VILLE_END_POINT+ "/{id}")
    ResponseEntity<VilleDTO> findById(@PathVariable Integer id);

    @GetMapping(value = VILLE_END_POINT)
    ResponseEntity<List<VilleDTO>> findAll();

    @PutMapping(value = VILLE_END_POINT+ "/{id1}")
    ResponseEntity<VilleDTO> update(@PathVariable("id1") Integer id, @RequestBody VilleDTO dto);

    @DeleteMapping(value = VILLE_END_POINT+ "/{id2}")
    ResponseEntity delete(@PathVariable("id2") Integer id);
}
