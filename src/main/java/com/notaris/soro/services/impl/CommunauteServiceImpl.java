package com.notaris.soro.services.impl;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.CommunauteDTO;
import com.notaris.soro.dto.DocumentsCommunauteDTO;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.Documents;
import com.notaris.soro.models.DocumentsCommunaute;
import com.notaris.soro.repositories.CommunauteRepository;
import com.notaris.soro.repositories.DocumentCommunauteRepository;
import com.notaris.soro.services.CommunauteService;
import com.notaris.soro.validators.CommunauteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommunauteServiceImpl implements CommunauteService {

    private final CommunauteRepository communauteRepository;
    private final DocumentCommunauteServiceImpl service;
    private final DocumentCommunauteRepository documentCommunauteRepository;

    public CommunauteServiceImpl(CommunauteRepository communauteRepository, DocumentCommunauteServiceImpl service, DocumentCommunauteRepository documentCommunauteRepository) {
        this.communauteRepository = communauteRepository;
        this.service = service;
        this.documentCommunauteRepository = documentCommunauteRepository;
    }

    @Override
    public CommunauteDTO save(CommunauteDTO dto) {
        List<String> errors = CommunauteValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("objet invalide {}", dto);
            throw  new InvalidEntityException("L'objet renseigné est invalide", errors);
        }

        return CommunauteDTO.toEntityDTO(communauteRepository.save(CommunauteDTO.toEntity(dto)));
    }

    @Override
    public CommunauteDTO findById(Integer id) {
        if(id == null){
            log.info("l'id fourni est null");
            throw new EntityNotFoundException("Impossible de trouver une liquidation de commauté avec un id null");
        }
        return communauteRepository.findById(id).map(CommunauteDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucune Liquidation de session n'a été trouvée");
        });
    }

    @Override
    public List<CommunauteDTO> findAll() {
        return communauteRepository.findAll().stream().map(CommunauteDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public CommunauteDTO findByIntitule(String intitule) {
        if(intitule == null){
            log.info("l'intitule fourni est null");
            throw new EntityNotFoundException("Impossible de trouver une liquidation avec un intitulé null");
        }
        return communauteRepository.findByIntitule(intitule).map(CommunauteDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucune liquidation de communauté avec l'intitulé: " + intitule  + " existe dans la BD");
        });
    }

    @Override
    public CommunauteDTO save(Integer idDossier, MultipartFile files) throws IOException {
        if(files == null){
            log.info("l'objet fournit est invalide");
            throw new InvalidEntityException("L'objet fournit est invalide");
        }
        if(idDossier == null){
            log.info("l'id fournit est null");
            throw new EntityNotFoundException("Impossible de trouver un client Moral avec un id null");
        }

        // verifier si le dossier existe avec l'id fournit
        if(!documentCommunauteRepository.existsById(idDossier)){
            log.info("aucun dossier n'existe pour cet id de dossier: " + idDossier);
            throw new EntityNotFoundException("aucun dossier n'existe pour cet id de dossier: " + idDossier);
        }


        // ajouter le document au dossier existant
        CommunauteDTO communauteDTO = findById(idDossier);
        List<DocumentsCommunauteDTO> dtoList = new ArrayList<>();
        DocumentsCommunaute doc = service.saveFileAndDocId(files, CommunauteDTO.toEntity(communauteDTO));

        dtoList.add(DocumentsCommunauteDTO.toEntityDTO(doc));
        doc.setDoccommunuate(CommunauteDTO.toEntity(communauteDTO));
        communauteDTO.setDocumentsDTOList(dtoList);

        CommunauteDTO dtosave = save(communauteDTO);
        return dtosave;
    }

    @Override
    public List<DocumentsCommunauteDTO> findCommunauteDocByIdDossier(Integer id) {
        if(id == null){
            log.info("l'id renseigné est null");
            throw new EntityNotFoundException("impossible de trouver une Acte immobilier avec un id null");
        }

        return documentCommunauteRepository.findAllByDoccommunuateId(id).stream().map(DocumentsCommunauteDTO::toEntityDTO).collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
       if(id == null){
           log.info("l'intitule fourni est null");
           throw new EntityNotFoundException("Impossible de trouver une liquidation avec un intitulé null");
       }
       communauteRepository.deleteById(id);
    }
}
