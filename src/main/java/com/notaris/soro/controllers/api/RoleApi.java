package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.admin.PaysDTO;
import com.notaris.soro.dto.admin.RolesDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.notaris.soro.utils.Constantes.PAYS_END_POINT;
import static com.notaris.soro.utils.Constantes.ROLE_END_POINT;

@Tag(name = ROLE_END_POINT, description = "L'API pour gerer les roles")
public interface RoleApi {

    @PostMapping(value = ROLE_END_POINT)
    ResponseEntity<RolesDTO> save(@RequestBody RolesDTO dto);

    @GetMapping(value = ROLE_END_POINT+ "/{id}")
    ResponseEntity<RolesDTO> findById(@PathVariable("id") Integer id);

    @GetMapping(value = ROLE_END_POINT)
    ResponseEntity<List<RolesDTO>> findAll();

    @DeleteMapping(value = ROLE_END_POINT+ "/{id2}")
    ResponseEntity delete(@PathVariable("id2") Integer id);
}
