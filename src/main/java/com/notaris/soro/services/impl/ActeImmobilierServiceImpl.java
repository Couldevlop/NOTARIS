package com.notaris.soro.services.impl;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.Documents;
import com.notaris.soro.repositories.ActeImmobilierRepository;
import com.notaris.soro.repositories.DocumentRepository;
import com.notaris.soro.services.ActeImmoService;
import com.notaris.soro.validators.ActeImmobilierValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActeImmobilierServiceImpl implements ActeImmoService {
   @Autowired
    private ActeImmobilierRepository acteImmobilierRepository;
   @Autowired
    private DocumentServiceImpl service;
   @Autowired
   private DocumentRepository documentRepository;


    @Override
    public ActeImmobilierDTO save(ActeImmobilierDTO dto) {
        List<String> errors = ActeImmobilierValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("L'objet est vide {} ", dto);
            throw new InvalidEntityException("l'objet est invalide");
        }

        return ActeImmobilierDTO.toEntityDTO(acteImmobilierRepository.save(ActeImmobilierDTO.toEntity(dto)));
    }


    @Override
    public ActeImmobilierDTO findById(Integer id) {
        if(id == null){
            return null;
        }
        return acteImmobilierRepository.findById(id).map(ActeImmobilierDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucune acte immobilier avec l'id" + id + "n'a été trouvé");
        });
    }

    @Override
    public List<ActeImmobilierDTO> findAll() {
        return acteImmobilierRepository.findAll().stream().map(ActeImmobilierDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
         acteImmobilierRepository.deleteById(id);
    }

    @Override
    public ActeImmobilierDTO save(Integer idDossier,  MultipartFile files) throws IOException {
        if(files == null){
            log.info("l'objet fournit est invalide");
            throw new InvalidEntityException("L'objet fournit est invalide");
        }
        if(idDossier == null){
            log.info("l'id fournit est null");
            throw new EntityNotFoundException("Impossible de trouver un client Moral avec un id null");
        }

        // verifier si le dossier existe avec l'id fournit
        if(!documentRepository.existsById(idDossier)){
            log.info("aucun dossier n'existe pour cet id de dossier: " + idDossier);
            throw new EntityNotFoundException("aucun dossier n'existe pour cet id de dossier: " + idDossier);
        }


        // ajouter le document au dossier existant
        ActeImmobilierDTO acteImmobilierDTO = findById(idDossier);
        List<DocumentsDTO> dtoList = new ArrayList<>();
        /*Integer id = acteImmobilierDTO.getId();
        Documents d = new Documents();
        d.setActeimmo(ActeImmobilierDTO.toEntity(acteImmobilierDTO));
        d.setDocType(files.getContentType());
        d.setData(files.getBytes());
        d.setDocName(files.getOriginalFilename());*/

        Documents doc = service.saveFileAndDocId(files, ActeImmobilierDTO.toEntity(acteImmobilierDTO));

        dtoList.add(DocumentsDTO.toEntityDTO(doc));
        doc.setActeimmo(ActeImmobilierDTO.toEntity(acteImmobilierDTO));
        acteImmobilierDTO.setDocumentsDTOList(dtoList);

        ActeImmobilierDTO dtosave = save(acteImmobilierDTO);
        return dtosave;
    }


    public List<DocumentsDTO> findActeImmoDocByIddossier(@PathVariable(value = "iddossier") Integer iddossier){
        if(iddossier == null){
            log.info("l'id renseigné est null");
            throw new EntityNotFoundException("impossible de trouver une Acte immobilier avec un id null");
        }

        return documentRepository.findAllByActeimmoId(iddossier).stream().map(DocumentsDTO::toEntityDTO).collect(Collectors.toList());


    }
}
