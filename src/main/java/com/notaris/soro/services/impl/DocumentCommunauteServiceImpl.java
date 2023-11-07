package com.notaris.soro.services.impl;

import com.notaris.soro.dto.CommunauteDTO;
import com.notaris.soro.dto.DocumentsCommunauteDTO;
import com.notaris.soro.dto.DocumentsSuccesionDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.models.DocumentsCommunaute;
import com.notaris.soro.models.liquidation.Communaute;
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

import static com.notaris.soro.dto.DocumentsCommunauteDTO.toListEntityDTO;

@Service
public class DocumentCommunauteServiceImpl {

    private final CommunauteRepository communauteRepository;
    private final DocumentCommunauteRepository documentCommunauteRepository;


    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    //private final Path rootLocation = Paths.get("C:\\Users\\Public\\webservice\\sysgescom");
    private final Path root = Paths.get("uploads");

    public DocumentCommunauteServiceImpl(CommunauteRepository communauteRepository, DocumentCommunauteRepository documentCommunauteRepository){

        this.communauteRepository = communauteRepository;
        this.documentCommunauteRepository = documentCommunauteRepository;
    }
   // private final Path rootLocation = Paths.get("upload");


    public DocumentsCommunaute saveFile(MultipartFile file) {
        String docname = file.getOriginalFilename();

        try {

            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            DocumentsCommunaute doc = new DocumentsCommunaute(docname,file.getContentType(),file.getBytes());

            return documentCommunauteRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public DocumentsCommunauteDTO saveWitFile(MultipartFile file, String intitule, String communauteId, String typeDoc) {
        String docname = file.getOriginalFilename();

        try {
             DocumentsCommunaute name = documentCommunauteRepository.findByDocName(docname);
             if(name != null){
                 throw new EntityNotFoundException("Le fichier existe déjà. Merci de bien vouloir choisir un autre");
             }
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            CommunauteDTO communauteDTO = CommunauteDTO.toEntityDTO(communauteRepository.findById(Integer.parseInt(communauteId)).get());
            DocumentsCommunaute doc = new DocumentsCommunaute(typeDoc,intitule,docname,file.getContentType(),file.getBytes(),CommunauteDTO.toEntity(communauteDTO));


            return DocumentsCommunauteDTO.toEntityDTO(documentCommunauteRepository.save(doc));
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
    public DocumentsCommunaute saveFileAndDocId(MultipartFile file, Communaute communaute) {
        String docname = file.getOriginalFilename();

        try {
            if(Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()))  == docname.length()){
                throw new FileAlreadyExistsException("Un fichier existe déjà");
            }
            Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
            DocumentsCommunaute doc = new DocumentsCommunaute();
            doc.setDocName(docname);
            doc.setTypeDoc(file.getContentType());
            doc.setData(file.getBytes());
            doc.setDoccommunuate(communaute);

            return documentCommunauteRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public DocumentsCommunauteDTO getFile(Integer fileId)
    {
        return documentCommunauteRepository.findById(fileId).map(DocumentsCommunauteDTO::toEntityDTO).orElseThrow(()->{
            throw null;
        });
    }
    public List<DocumentsCommunauteDTO> getFiles(){

        return DocumentsCommunauteDTO.toListEntityDTO(documentCommunauteRepository.findAll());
    }
}
