package com.notaris.soro.services.impl;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.models.ActeImmobilier;
import com.notaris.soro.models.Documents;
import com.notaris.soro.repositories.*;
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
    private final SuccessionRepository successionRepository;
    private final CommunauteRepository communauteRepository;
    private final ModificationRepository modificationRepository;
    private final DocumentModifSocieteRepository documentModifSocieteRepository;

    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    //private final Path rootLocation = Paths.get("C:\\Users\\Public\\webservice\\sysgescom");
    private final Path root = Paths.get("uploads");

    public DocumentServiceImpl(DocumentRepository documentRepository, ActeImmobilierRepository acteImmobilierRepository, SuccessionRepository successionRepository, CommunauteRepository communauteRepository, ModificationRepository modificationRepository, DocumentModifSocieteRepository documentModifSocieteRepository) {
        this.documentRepository = documentRepository;
        this.acteImmobilierRepository = acteImmobilierRepository;
        this.successionRepository = successionRepository;
        this.communauteRepository = communauteRepository;
        this.modificationRepository = modificationRepository;
        this.documentModifSocieteRepository = documentModifSocieteRepository;
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
            Documents doc = new Documents(typeDoc,intitule,docname,file.getContentType(),file.getBytes(),ActeImmobilierDTO.toEntity(immo));

            return toEntityDTO(documentRepository.save(doc));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


/*
    public DocumentsDTO saveWitFileSuccession(MultipartFile file, String intitule, String successionId, String typeDoc) {
        String docname = file.getOriginalFilename();

        try {
            Documents name = documentRepository.findByDocName(docname);
            if(name != null){
                throw new EntityNotFoundException("Le fichier existe déjà. Merci de bien vouloir choisir un autre");
            }
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            SucessionDTO succession = SucessionDTO.toEntityDTO(successionRepository.findById(Integer.parseInt(successionId)).get());
            Documents doc = new Documents(Integer.parseInt(successionId),typeDoc,intitule,docname,file.getContentType(),file.getBytes(),SucessionDTO.toEntity(succession));

            return toEntityDTO(documentRepository.save(doc));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
*/

/*
    public DocumentsDTO saveWitFileCommunaute(MultipartFile file, String intitule, String comId, String typeDoc) {
        String docname = file.getOriginalFilename();

        try {
            Documents name = documentRepository.findByDocName(docname);
            if(name != null){
                throw new EntityNotFoundException("Le fichier existe déjà. Merci de bien vouloir choisir un autre");
            }
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            CommunauteDTO communauteDTO = CommunauteDTO.toEntityDTO(communauteRepository.findById(Integer.parseInt(comId)).get());
            Documents doc = new Documents(Integer.parseInt(comId),typeDoc,intitule,docname,file.getContentType(),file.getBytes(),CommunauteDTO.toEntity(communauteDTO));

            return toEntityDTO(documentRepository.save(doc));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
*/



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

    /*public DocumentsModifSociete saveFileAndDocId(MultipartFile file, Modification modification) {
        String docname = file.getOriginalFilename();

        try {
            if(Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()))  == docname.length()){
                throw new FileAlreadyExistsException("Un fichier existe déjà");
            }
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            DocumentsModifSociete doc = new DocumentsModifSociete();
            doc.setDocName(docname);
            doc.setTypeDoc(file.getContentType());
            doc.setData(file.getBytes());
            doc.setModifscte(modification);

            return documentModifSocieteRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }*/
    public Documents getFile(Integer fileId)
    {
        return documentRepository.findById(fileId).map(DocumentsDTO::toEntity).orElseThrow(()->{
            throw new EntityNotFoundException("Aucune fichier correspondant à cet identifiant " + fileId + " n'a été trouvé dans la BD");
        });
    }
    public List<DocumentsDTO> getFiles(){
        return toListEntityDTO(documentRepository.findAll());
    }
}
