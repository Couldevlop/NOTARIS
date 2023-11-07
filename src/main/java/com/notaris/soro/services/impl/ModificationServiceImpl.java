package com.notaris.soro.services.impl;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.dto.DocumentsModifSocieteDTO;
import com.notaris.soro.dto.ModificationDTO;
import com.notaris.soro.exceptions.EntityAlreadyExistException;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.ActeImmobilier;
import com.notaris.soro.models.Documents;
import com.notaris.soro.models.DocumentsModifSociete;
import com.notaris.soro.models.societe.Modification;
import com.notaris.soro.repositories.DocumentModifSocieteRepository;
import com.notaris.soro.repositories.DocumentRepository;
import com.notaris.soro.repositories.ModificationRepository;
import com.notaris.soro.services.ModificationService;
import com.notaris.soro.validators.ModificationValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ModificationServiceImpl implements ModificationService {
    private final ModificationRepository modificationRepository;
    private final DocumentServiceImpl service;
    private final DocumentModifSocieteRepository documentModifSocieteRepository;

    private final DocumentRepository documentRepository;
    private final Path root = Paths.get("uploads");

    public ModificationServiceImpl(DocumentModifSocieteRepository documentModifSocieteRepository,ModificationRepository modificationRepository, DocumentServiceImpl service, DocumentRepository documentRepository) {
        this.modificationRepository = modificationRepository;
        this.service = service;
        this.documentRepository = documentRepository;
        this.documentModifSocieteRepository = documentModifSocieteRepository;
    }


    @Override
    public ModificationDTO save(ModificationDTO dto) {
        List<String> errors = ModificationValidator.validate(dto);

        if(!errors.isEmpty()){
            log.info("l'objet est invalide");
            throw new InvalidEntityException("Objet est invalide {} ", errors);
        }
        if(modificationRepository.findByObjet(dto.getObjet()) != null){
            log.info("l'objet existe déjà");
            throw new EntityAlreadyExistException("l'objet exite déjà avec cet objet " + dto.getObjet(), errors);
        }
        return ModificationDTO.toEntityDTO(modificationRepository.save(ModificationDTO.toEntity(dto)));
    }

    @Override
    public ModificationDTO findById(Integer id) {
        if(id == null){
            log.info("l'id " + id + " est null");
            throw new EntityNotFoundException("Impossible de trouver un reseultat avec un id null");
        }
        return modificationRepository.findById(id).map(ModificationDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucun résultat ne correspond ne correspond à cet id " + id + " dans la BD ");
        });
    }

    @Override
    public List<ModificationDTO> findAll() {
        return modificationRepository.findAll().stream().map(ModificationDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public ModificationDTO update(Integer id, ModificationDTO dto) {
        List<String> errors = ModificationValidator.validate(dto);
        if(id == null){
            log.info("l'id " + id + " est null");
            throw new EntityNotFoundException("Impossible de trouver un reseultat avec un id null");
        }if(!errors.isEmpty()){
            log.info("l'objet est invalide");
            throw new InvalidEntityException("Objet est invalide {} ", errors);
        }if(modificationRepository.existsById(id) == false){
            log.info("Aucun résultat trouvé");
            throw new EntityNotFoundException("Aucun résultat ne correspond à l'id " + id);
        }
        Modification modification = modificationRepository.findById(id).get();
        modification.setClient(dto.getClient());
        modification.setObjet(dto.getObjet());
        modification.setDateOuverture(dto.getDateOuverture());
        modification.setMotif(dto.getMotif());
        modification.setNatureSociete(dto.getNatureSociete());
        modification.setTypeSociete(dto.getTypeSociete());
        modification.setId(dto.getId());
        return ModificationDTO.toEntityDTO(modificationRepository.save(modification));
    }

    /*@Override
    public ModificationDTO save(Integer idDossier, MultipartFile files) throws IOException {
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
        ModificationDTO modificationDTO = findById(idDossier);
        List<DocumentsModifSocieteDTO> dtoList = new ArrayList<>();

        DocumentsModifSociete doc = service.saveFileAndDocId(files, ModificationDTO.toEntity(modificationDTO));

        dtoList.add(DocumentsModifSocieteDTO.toEntityDTO(doc));
        doc.setModifscte(ModificationDTO.toEntity(modificationDTO));
        modificationDTO.setDocumentsDTOList(dtoList);

        ModificationDTO dtosave = save(modificationDTO);
        return dtosave;
    }

    @Override
    public List<DocumentsModifSocieteDTO> findActeModifScteDocByIddossier(Integer iddossier) {
        if (iddossier == null) {
            log.info("l'id renseigné est null");
            throw new EntityNotFoundException("impossible de trouver une Acte immobilier avec un id null");
        }

        return documentModifSocieteRepository.findAllByModifscte(iddossier).stream().map(DocumentsModifSocieteDTO::toEntityDTO).collect(Collectors.toList());
    }

*/



    @Override
    public void delete(Integer id) {
        if(id == null) {
            log.info("id est null");
            throw new EntityNotFoundException("Impossible de trouver un resultat à supprimer avec un id null") ;
        }
        modificationRepository.deleteById(id);
    }



}
