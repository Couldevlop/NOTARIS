package com.notaris.soro.controllers.api;

import com.notaris.soro.dto.BanqueDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.notaris.soro.utils.Constantes.*;

@Tag(name = CLIENT_BANQUE_END_POINT, description = "l'API pour le client Banque")
public interface BanqueApi {
    @PostMapping(value = CLIENT_BANQUE_END_POINT, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BanqueDTO> save(@RequestPart MultipartFile file, @RequestPart BanqueDTO dto) throws IOException;

    @GetMapping(value = CLIENT_BANQUE_END_POINT+ "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BanqueDTO> findById(@PathVariable Integer id);

    @GetMapping(value = CLIENT_BANQUE_END_POINT, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<BanqueDTO>> findAll();

    @GetMapping(value = CLIENT_BANQUE_END_POINT+ "/{sigle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BanqueDTO> findBySigle(@PathVariable String sigle);

    @DeleteMapping(value = CLIENT_BANQUE_END_POINT+ "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity delete(Integer id);

    @PostMapping(value = CLIENT_BANQUE_END_POINT+ "/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BanqueDTO> create(@RequestBody BanqueDTO dto);
}
