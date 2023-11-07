package com.notaris.soro.services.impl;

import com.notaris.soro.dto.DocumentsSuccesionDTO;
import com.notaris.soro.dto.SuccessionDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.DocumentsSuccession;
import com.notaris.soro.repositories.DocumentSuccesionRepository;
import com.notaris.soro.repositories.SuccessionRepository;
import com.notaris.soro.services.SuccessionService;
import com.notaris.soro.validators.SucessionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SuccessionServiceImpl implements SuccessionService {
    private final SuccessionRepository successionRepository;
    private final DocumentSuccessionServiceImpl service;
    private final DocumentSuccesionRepository documentSuccesionRepository;
    public SuccessionServiceImpl(SuccessionRepository successionRepository, DocumentSuccessionServiceImpl service, DocumentSuccesionRepository documentSuccesionRepository) {
        this.successionRepository = successionRepository;
        this.service = service;
        this.documentSuccesionRepository = documentSuccesionRepository;
    }


    @Override
    public SuccessionDTO save(SuccessionDTO dto) {
        List<String> errors = SucessionValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("Objet invalid {}", dto);
            throw new InvalidEntityException("L'objet fourni est invalide", errors);
        }
        return SuccessionDTO.toEntityDTO(successionRepository.save(SuccessionDTO.toEntity(dto)));
    }

    @Override
    public SuccessionDTO findById(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw new EntityNotFoundException("Impossible de trouver une liquidation de session pour un id null");
        }
        return successionRepository.findById(id).map(SuccessionDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucune liquidation de session ne correspond à l'id" + id);
        });
    }

    @Override
    public List<SuccessionDTO> findAll() {
        return successionRepository.findAll().stream().map(SuccessionDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public SuccessionDTO findByIntitule(String intitule) {
        if(intitule == null){
            log.info("l'intitulé est null");
            throw new EntityNotFoundException("Impossible de trouver une liquidation correspondant à l'intitule " + intitule);
        }
        return successionRepository.findByIntitule(intitule).map(SuccessionDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucune liquidation de session ne correspond à l'intitul" + intitule);
        });
    }

    @Override
    public SuccessionDTO save(Integer idDossier, MultipartFile files) throws IOException {
        if(files == null){
            log.info("l'objet fournit est invalide");
            throw new InvalidEntityException("L'objet fournit est invalide");
        }
        if(idDossier == null){
            log.info("l'id fournit est null");
            throw new EntityNotFoundException("Impossible de trouver un client Moral avec un id null");
        }

        // verifier si le dossier existe avec l'id fournit
        if(!documentSuccesionRepository.existsById(idDossier)){
            log.info("aucun dossier n'existe pour cet id de dossier: " + idDossier);
            throw new EntityNotFoundException("aucun dossier n'existe pour cet id de dossier: " + idDossier);
        }


        // ajouter le document au dossier existant
        SuccessionDTO successionDTO = findById(idDossier);
        List<DocumentsSuccesionDTO> dtoList = new ArrayList<>();
        DocumentsSuccession doc = service.saveFileAndDocId(files, SuccessionDTO.toEntity(successionDTO));

        dtoList.add(DocumentsSuccesionDTO.toEntityDTO(doc));
        doc.setDocsuccession(SuccessionDTO.toEntity(successionDTO));
        successionDTO.setDocumentsDTOList(dtoList);

        SuccessionDTO dtosave = save(successionDTO);
        return dtosave;
    }

    @Override
    public List<DocumentsSuccesionDTO> findSuccessionByIdDossier(Integer id) {
        if(id == null){
            log.info("l'id renseigné est null");
            throw new EntityNotFoundException("impossible de trouver une Acte immobilier avec un id null");
        }

        return documentSuccesionRepository.findAllBydocsuccessionId(id).stream().map(DocumentsSuccesionDTO::toEntityDTO).collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.info("l'intitule fourni est null");
            throw new EntityNotFoundException("Impossible de trouver une liquidation avec un intitulé null");
        }
       successionRepository.deleteById(id);
    }
}
