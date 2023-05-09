package com.notaris.soro.services.impl;

import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.models.ActeImmobilier;
import com.notaris.soro.models.Documents;
import com.notaris.soro.repositories.DocumentRepository;
import com.notaris.soro.services.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl {

    private final DocumentRepository documentRepository;

    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    //private final Path rootLocation = Paths.get("C:\\Users\\Public\\webservice\\sysgescom");
    private final Path root = Paths.get("uploads");

    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }
   // private final Path rootLocation = Paths.get("upload");


    public Documents saveFile(MultipartFile file) {
        String docname = file.getOriginalFilename();

        try {

            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            Documents doc = new Documents(docname,file.getContentType(),file.getBytes());

            return documentRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public Documents saveFileAndDocId(MultipartFile file, ActeImmobilier immo) {
        String docname = file.getOriginalFilename();

        try {

            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            Documents doc = new Documents(docname,file.getContentType(),file.getBytes(), immo);

            return documentRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Documents getFile(Integer fileId)
    {
        return documentRepository.findById(fileId).map(DocumentsDTO::toEntity).orElseThrow(()->{
            throw null;
        });
    }
    public List<Documents> getFiles(){
        return documentRepository.findAll();
    }
}
