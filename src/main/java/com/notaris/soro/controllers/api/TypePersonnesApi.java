package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.admin.TypePersonnesDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.TYPE_PERSONNES_END_POINT;

@Tag(name = TYPE_PERSONNES_END_POINT, description = "L'API pour gerer les type de personnes")
public interface TypePersonnesApi {

    @PostMapping(value = TYPE_PERSONNES_END_POINT)
    ResponseEntity<TypePersonnesDTO >save(@RequestBody TypePersonnesDTO dto);

    @GetMapping(value = TYPE_PERSONNES_END_POINT+ "/{id}")
    ResponseEntity<TypePersonnesDTO> findById(@PathVariable Integer id);

    @GetMapping(value = TYPE_PERSONNES_END_POINT)
    ResponseEntity<List<TypePersonnesDTO>> findAll();

    @PutMapping(value = TYPE_PERSONNES_END_POINT+ "/{id1}")
    ResponseEntity <TypePersonnesDTO> update(@PathVariable("id1") Integer id, @RequestBody TypePersonnesDTO dto);

    @DeleteMapping(TYPE_PERSONNES_END_POINT+ "/{id2}")
    ResponseEntity delete(@PathVariable("id2") Integer id);
}
