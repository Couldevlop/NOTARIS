package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.admin.TypeSuccessionsDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.TYPE_SUCCESSIONS_END_POINT;

@Tag(name = TYPE_SUCCESSIONS_END_POINT, description = "L'API pour gerer le type de succession")
public interface TypeSuccessionsApi {

    @PostMapping(value = TYPE_SUCCESSIONS_END_POINT)
    ResponseEntity<TypeSuccessionsDTO> save(@RequestBody TypeSuccessionsDTO dto);

    @GetMapping(value = TYPE_SUCCESSIONS_END_POINT+ "/{id}")
    ResponseEntity<TypeSuccessionsDTO> findById(@PathVariable("id") Integer id);

    @GetMapping(value = TYPE_SUCCESSIONS_END_POINT)
    ResponseEntity<List<TypeSuccessionsDTO>> findAll();

    @PutMapping(value = TYPE_SUCCESSIONS_END_POINT+ "/{id1}")
    ResponseEntity<TypeSuccessionsDTO> update(@PathVariable("id1") Integer id, @RequestBody TypeSuccessionsDTO dto);

    @DeleteMapping(value = TYPE_SUCCESSIONS_END_POINT+ "/{id2}")
    ResponseEntity delete(@PathVariable("id2") Integer id);
}
