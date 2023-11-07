package com.notaris.soro.services.impl;

import com.notaris.soro.dto.DocumentsSuccesionDTO;
import com.notaris.soro.dto.SuccessionDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.models.DocumentsSuccession;
import com.notaris.soro.models.liquidation.Succession;
import com.notaris.soro.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.notaris.soro.dto.DocumentsSuccesionDTO.toListEntityDTO;

@Service
public class DocumentSuccessionServiceImpl {
    private final SuccessionRepository successionRepository;
    private final DocumentSuccesionRepository documentSuccesionRepository;

    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    //private final Path rootLocation = Paths.get("C:\\Users\\Public\\webservice\\sysgescom");
    private final Path root = Paths.get("uploads");

    public DocumentSuccessionServiceImpl(ActeImmobilierRepository acteImmobilierRepository, ModificationRepository modificationRepository, SuccessionRepository successionRepository, DocumentModifSocieteRepository documentModifSocieteRepository,
                                         DocumentSuccesionRepository documentSuccesionRepository) {
        this.successionRepository = successionRepository;
        this.documentSuccesionRepository = documentSuccesionRepository;
    }
   // private final Path rootLocation = Paths.get("upload");


    public DocumentsSuccession saveFile(MultipartFile file) {
        String docname = file.getOriginalFilename();

        try {

            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            DocumentsSuccession doc = new DocumentsSuccession(docname,file.getContentType(),file.getBytes());

            return documentSuccesionRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public DocumentsSuccesionDTO saveWitFile(MultipartFile file, String intitule, String successionId, String typeDoc) {
        String docname = file.getOriginalFilename();

        try {
             DocumentsSuccession name = documentSuccesionRepository.findByDocName(docname);
             if(name != null){
                 throw new EntityNotFoundException("Le fichier existe déjà. Merci de bien vouloir choisir un autre");
             }
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            SuccessionDTO successionDTO = SuccessionDTO.toEntityDTO(successionRepository.findById(Integer.parseInt(successionId)).get());
            DocumentsSuccession doc = new DocumentsSuccession(typeDoc,intitule,docname,file.getContentType(),file.getBytes(), SuccessionDTO.toEntity(successionDTO));

            return DocumentsSuccesionDTO.toEntityDTO(documentSuccesionRepository.save(doc));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


   /* public DocumentsSuccession saveFileAndDocId(MultipartFile file, Sucession sucession) {
        String docname = file.getOriginalFilename();

        try {

            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            DocumentsSuccession doc = new DocumentsSuccession(docname,file.getContentType(),file.getBytes(), sucession);

            return documentSuccesionRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
*/
    public DocumentsSuccession saveFileAndDocId(MultipartFile file, Succession succession) {
        String docname = file.getOriginalFilename();

        try {
            if(Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()))  == docname.length()){
                throw new FileAlreadyExistsException("Un fichier existe déjà");
            }
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            DocumentsSuccession doc = new DocumentsSuccession();
            doc.setDocName(docname);
            doc.setTypeDoc(file.getContentType());
            doc.setData(file.getBytes());
            doc.setDocsuccession(succession);

            return documentSuccesionRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public DocumentsSuccesionDTO getFile(Integer fileId)
    {
        return documentSuccesionRepository.findById(fileId).map(DocumentsSuccesionDTO::toEntityDTO).orElseThrow(()->{
            throw null;
        });
    }
    public List<DocumentsSuccesionDTO> getFiles(){

        return toListEntityDTO(documentSuccesionRepository.findAll());
    }
}
