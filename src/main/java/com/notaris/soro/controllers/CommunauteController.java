package com.notaris.soro.controllers;

import com.notaris.soro.controllers.api.CommunauteApi;
import com.notaris.soro.dto.CommunauteDTO;
import com.notaris.soro.dto.DocumentsCommunauteDTO;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.dto.DocumentsSuccesionDTO;
import com.notaris.soro.services.CommunauteService;
import com.notaris.soro.services.impl.DocumentCommunauteServiceImpl;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@PreAuthorize(" hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CommunauteController implements CommunauteApi {
    private final CommunauteService communauteService;
    private final DocumentCommunauteServiceImpl service;

    public CommunauteController(CommunauteService communauteService, DocumentCommunauteServiceImpl service) {
        this.communauteService = communauteService;
        this.service = service;
    }


    @Override
    public ResponseEntity<CommunauteDTO> save(CommunauteDTO dto) {
        return ResponseEntity.ok(communauteService.save(dto));
    }

    @Override
    public ResponseEntity<DocumentsCommunauteDTO> saveWitFile(MultipartFile file, String intitule, String id, String typeDoc) {
        return ResponseEntity.ok(service.saveWitFile(file,intitule, id,typeDoc));
    }

    @Override
    public ResponseEntity<ByteArrayResource> downloadFile(Integer fileId) {
        if(fileId == null){

        }
        DocumentsCommunauteDTO doc = service.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(doc.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
                .body(new ByteArrayResource(doc.getData()));
    }


    @Override
    public ResponseEntity<List<DocumentsCommunauteDTO>> findCommunauteDocByIdDossier(Integer id) {
        return ResponseEntity.ok(communauteService.findCommunauteDocByIdDossier(id));
    }

    @Override
    public ResponseEntity<CommunauteDTO> findById(Integer id) {
        return ResponseEntity.ok(communauteService.findById(id));
    }

    @Override
    public ResponseEntity<List<CommunauteDTO>> findAll() {
        return ResponseEntity.ok(communauteService.findAll());
    }

    @Override
    public ResponseEntity<CommunauteDTO> findByIntitule(String intitule) {
        return ResponseEntity.ok(communauteService.findByIntitule(intitule));
    }

    @Override
    public ResponseEntity delete(Integer id1) {
        communauteService.delete(id1);
        return ResponseEntity.ok().build();
    }
}
