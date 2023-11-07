package com.notaris.soro.services.impl;

import com.notaris.soro.dto.CreationDTO;
import com.notaris.soro.exceptions.EntityAlreadyExistException;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.societe.Creation;
import com.notaris.soro.repositories.ConstitutionRepository;
import com.notaris.soro.services.ConstitutionService;
import com.notaris.soro.validators.CreationValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ConstitutionServiceImpl implements ConstitutionService {
    private final ConstitutionRepository constitutionRepository;

    public ConstitutionServiceImpl(ConstitutionRepository constitutionRepository) {
        this.constitutionRepository = constitutionRepository;
    }

    @Override
    public CreationDTO save(CreationDTO dto) {
        List<String> errors = CreationValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("L'objet invalide {} ", dto);

            throw  new InvalidEntityException("L'objet fourni est invalide", errors);
        }if(constitutionRepository.findCreationByIntitule(dto.getIntitule()) != null){
            throw new EntityAlreadyExistException("La création existe déjà", errors);
        }
        return CreationDTO.toEntityDTO(constitutionRepository.save(CreationDTO.toEntity(dto)));
    }

    @Override
    public CreationDTO update(Integer id, CreationDTO dto) {
        List<String> errors = CreationValidator.validate(dto);
        if(id == null){
            log.info("l'id forunit est null");
            throw new EntityNotFoundException("Impossible de trouver un resultat avec un id null");
        }if(constitutionRepository.existsById(id) == false){
            log.info("Aucun resultat pour l'objet avec id= " + id);
            throw new EntityNotFoundException("Aucun resultat pour l'objet avec id= " + id);
        }
        if(!errors.isEmpty()){
            log.info("Lobjet est invalide");
            throw new InvalidEntityException("Objet invalide", errors);
        }
        CreationDTO creationDTO = findById(id);
        creationDTO.setClient(dto.getClient());
        creationDTO.setCommentaire(dto.getCommentaire());
        creationDTO.setTypeSociete(dto.getTypeSociete());
        creationDTO.setDateOuverture(dto.getDateOuverture());
        creationDTO.setNatureSociete(dto.getNatureSociete());
        creationDTO.setIntitule(dto.getIntitule());
        return CreationDTO.toEntityDTO(constitutionRepository.save(CreationDTO.toEntity(creationDTO)));
    }

    @Override
    public CreationDTO findById(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw new InvalidEntityException("impossible de trouver un objet avec un id null");
        }
        return constitutionRepository.findById(id).map(CreationDTO::toEntityDTO).orElseThrow(()->{
            throw new  EntityNotFoundException("Aucune constution d'entreprise trouvée");
        });
    }

    @Override
    public List<CreationDTO> findAll() {
        return constitutionRepository.findAll().stream().map(CreationDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public CreationDTO findByIntitule(String mot) {
        if(mot == null ){
            log.info("intitule null");
            throw  new InvalidEntityException("ompossible de trouver une constitution de société avec un intitulé null");
        }


        return constitutionRepository.findByIntitule(mot).map(CreationDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Impossible de trouver une constitution avec cet intitule " + mot);
        });
    }

    @Override
    public void delete(Integer id) {
        if(id == null ){
            log.info("intitule null");
            throw  new InvalidEntityException("ompossible de trouver une constitution de société avec un intitulé null");
        }
        constitutionRepository.deleteById(id);
    }
}
