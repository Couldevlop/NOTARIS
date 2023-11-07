package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.CommunauteDTO;
import com.notaris.soro.dto.DocumentsCommunauteDTO;
import com.notaris.soro.dto.DocumentsDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.notaris.soro.utils.Constantes.*;

@Tag(name = LIQUIDATION_COMMUNAUTE_END_POINT, description = "l'API pour la liquidation de communauté")
public interface CommunauteApi {

    @PostMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommunauteDTO> save(@RequestBody CommunauteDTO dto);

    @PostMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT+"/file", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,  MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<DocumentsCommunauteDTO> saveWitFile(@RequestParam(value = "file") MultipartFile file,
                                                       @RequestParam(value = "intitule") String intitule,
                                                       @RequestParam(value="id") String id,
                                                       @RequestParam(value = "typeDoc")  String typeDoc);

    @GetMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT+ "/downloadFile/{fileId}", produces = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId);

    @GetMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT+"/doc/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    ResponseEntity<List<DocumentsCommunauteDTO>> findCommunauteDocByIdDossier(@PathVariable Integer id);

    @GetMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT+ "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommunauteDTO> findById(@PathVariable Integer id);

    @GetMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<CommunauteDTO>> findAll();

    @GetMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT+ "/intitule/{intitule}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CommunauteDTO> findByIntitule(@PathVariable String intitule);

    @DeleteMapping(value = LIQUIDATION_COMMUNAUTE_END_POINT+ "/{id1}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity  delete(@PathVariable Integer id1);
}
