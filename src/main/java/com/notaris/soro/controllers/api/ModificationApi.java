package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsModifSocieteDTO;
import com.notaris.soro.dto.ModificationDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.notaris.soro.utils.Constantes.ACTE_IMMO_END_POINT;
import static com.notaris.soro.utils.Constantes.SOCIETE_MODIFICATION_END_POINT;

@Tag(name = SOCIETE_MODIFICATION_END_POINT, description = "L'API qui gère les modifications de societes")
public interface ModificationApi {
    @PostMapping(value = SOCIETE_MODIFICATION_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ModificationDTO> save(@RequestBody ModificationDTO dto);

    @GetMapping(value = SOCIETE_MODIFICATION_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ModificationDTO> findById(@PathVariable("id") Integer id);

    @GetMapping(value = SOCIETE_MODIFICATION_END_POINT,  produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ModificationDTO>> findAll();

    @PutMapping(value = SOCIETE_MODIFICATION_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ModificationDTO> update(@PathVariable Integer id, @RequestBody ModificationDTO dto);

    /*@PutMapping(value = SOCIETE_MODIFICATION_END_POINT+ "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ModificationDTO> save(@PathVariable(value = "id") Integer idDossier, @RequestPart MultipartFile file) throws IOException;

    @GetMapping(value =SOCIETE_MODIFICATION_END_POINT + "/{id1}" )
    ResponseEntity<List<DocumentsModifSocieteDTO>> findActeModifScteDocByIddossier(@PathVariable("id1") Integer id1);*/

    @DeleteMapping(value = SOCIETE_MODIFICATION_END_POINT+ "/{id2}")
    void delete(@PathVariable("id2") Integer id2);

}
