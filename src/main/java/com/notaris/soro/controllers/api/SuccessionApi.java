package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.DocumentsSuccesionDTO;
import com.notaris.soro.dto.SuccessionDTO;
import com.notaris.soro.models.Documents;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.notaris.soro.utils.Constantes.LIQUIDATION_SESSION_END_POINT;

@Tag(name = LIQUIDATION_SESSION_END_POINT, description = "l'API pour la liquidation de session")
public interface SuccessionApi {

    @PostMapping(value = LIQUIDATION_SESSION_END_POINT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<SuccessionDTO> save(@RequestBody SuccessionDTO dto);

    @PostMapping(value = LIQUIDATION_SESSION_END_POINT+"/file", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,  MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<DocumentsSuccesionDTO> saveWitFile(@RequestParam(value = "file") MultipartFile file,
                                                      @RequestParam(value = "intitule") String intitule,
                                                      @RequestParam(value="id") String id,
                                                      @RequestParam(value = "typeDoc")  String typeDoc);
    @GetMapping(value = LIQUIDATION_SESSION_END_POINT+"/doc/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    ResponseEntity<List<DocumentsSuccesionDTO>> findSuccessionByIdDossier(Integer id);

    @GetMapping(value = LIQUIDATION_SESSION_END_POINT+ "/downloadFile/{fileId}", produces = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
     ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId);


    @GetMapping(value = LIQUIDATION_SESSION_END_POINT+ "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<SuccessionDTO> findById(@PathVariable Integer id);

    @GetMapping(value = LIQUIDATION_SESSION_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<SuccessionDTO>> findAll();

    @GetMapping(value = LIQUIDATION_SESSION_END_POINT+ "/inititule/{intituleSession}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<SuccessionDTO> findByIntitule(@PathVariable String intituleSession);

    @DeleteMapping(value = LIQUIDATION_SESSION_END_POINT+ "/{id1}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity  delete(@PathVariable Integer id1);
}
