package com.notaris.soro.services.impl;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.models.ActeImmobilier;
import com.notaris.soro.models.Documents;
import com.notaris.soro.repositories.ActeImmobilierRepository;
import com.notaris.soro.repositories.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.notaris.soro.dto.DocumentsDTO.toEntityDTO;
import static com.notaris.soro.dto.DocumentsDTO.toListEntityDTO;

@Service
public class DocumentServiceImpl {

    private final DocumentRepository documentRepository;
    private final ActeImmobilierRepository acteImmobilierRepository;

    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    //private final Path rootLocation = Paths.get("C:\\Users\\Public\\webservice\\sysgescom");
    private final Path root = Paths.get("uploads");

    public DocumentServiceImpl(DocumentRepository documentRepository, ActeImmobilierRepository acteImmobilierRepository) {
        this.documentRepository = documentRepository;
        this.acteImmobilierRepository = acteImmobilierRepository;
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

    public DocumentsDTO saveWitFile(MultipartFile file, String intitule, String acteImmoId, String typeDoc) {
        String docname = file.getOriginalFilename();

        try {
             Documents name = documentRepository.findByDocName(docname);
             if(name != null){
                 throw new EntityNotFoundException("Le fichier existe déjà. Merci de bien vouloir choisir un autre");
             }
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            ActeImmobilierDTO immo = ActeImmobilierDTO.toEntityDTO(acteImmobilierRepository.findById(Integer.parseInt(acteImmoId)).get());
            Documents doc = new Documents(Integer.parseInt(acteImmoId),typeDoc,intitule,docname,file.getContentType(),file.getBytes(),ActeImmobilierDTO.toEntity(immo));

            return toEntityDTO(documentRepository.save(doc));
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
    public List<DocumentsDTO> getFiles(){
        return toListEntityDTO(documentRepository.findAll());
    }
}
