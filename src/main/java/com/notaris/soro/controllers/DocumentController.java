package com.notaris.soro.controllers;

import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.models.Documents;
import com.notaris.soro.models.ResponseMessage;
import com.notaris.soro.services.impl.DocumentServiceImpl;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@PreAuthorize(" hasRole('MODERATOR') or hasRole('MODERATOR') or hasRole('ADMIN')")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class DocumentController {

    private final DocumentServiceImpl storageService;
    private final Path rootLocation = Paths.get("upload");
    public DocumentController(DocumentServiceImpl storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId){
        if(fileId == null){

        }
        Documents doc = storageService.getFile(fileId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(doc.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
                .body(new ByteArrayResource(doc.getData()));
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename)
            throws MalformedURLException {

        Path file = this.rootLocation.resolve(filename);
        Resource resource = new UrlResource(file.toUri());

        return ResponseEntity
                .ok()
                .body(resource);
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> store(@RequestBody MultipartFile file){
        String message = "";
        try {

            storageService.saveFile(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/notaris/v1/allDoc")
    public ResponseEntity<List<DocumentsDTO>> getAll(){
        return  ResponseEntity.ok(storageService.getFiles());
    }

}
