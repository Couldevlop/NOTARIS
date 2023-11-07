package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.admin.TypePiecesDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.TYPE_PIECES_END_POINT;

@Tag(name = TYPE_PIECES_END_POINT, description = "L'API pour gerer le types de pieces")
public interface TypePiecesApi {
    @PostMapping(value = TYPE_PIECES_END_POINT)
    ResponseEntity<TypePiecesDTO> save(@RequestBody TypePiecesDTO dto);

    @GetMapping(value = TYPE_PIECES_END_POINT+ "/{id}")
    ResponseEntity<TypePiecesDTO> findById(@PathVariable Integer id);

    @GetMapping(value = TYPE_PIECES_END_POINT)
    ResponseEntity<List<TypePiecesDTO>> findAll();

    @PutMapping(value = TYPE_PIECES_END_POINT+ "/{id1}")
    ResponseEntity<TypePiecesDTO> update(@PathVariable("id1") Integer id, @RequestBody TypePiecesDTO dto);

    @DeleteMapping(value = TYPE_PIECES_END_POINT+ "{id2}")
    ResponseEntity delete(@PathVariable("id2") Integer id);
}
