package com.notaris.soro.services.impl;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.repositories.ActeImmobilierRepository;
import com.notaris.soro.repositories.DocumentRepository;
import com.notaris.soro.services.ActeImmoService;
import com.notaris.soro.validators.ActeImmobilierValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActeImmobilierServiceImpl implements ActeImmoService {

    private ActeImmobilierRepository acteImmobilierRepository;
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
    public DocumentsDTO save(Integer idDossier, DocumentsDTO dto) {
        if(dto == null){
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
        dtoList.add(DocumentsDTO.toEntityDTO(documentRepository.save(DocumentsDTO.toEntity(dto))));
        acteImmobilierDTO.setDocumentsDTOList(dtoList);
        save(acteImmobilierDTO);
        return dto;
    }
}
