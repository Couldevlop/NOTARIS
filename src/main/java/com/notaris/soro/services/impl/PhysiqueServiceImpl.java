package com.notaris.soro.services.impl;

import com.notaris.soro.dto.PhysiqueDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.repositories.PhysiqueRepository;
import com.notaris.soro.services.PhysiqueService;
import com.notaris.soro.validators.PhysiqueValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PhysiqueServiceImpl implements PhysiqueService {
    private final PhysiqueRepository physiqueRepository;

    public PhysiqueServiceImpl(PhysiqueRepository physiqueRepository) {
        this.physiqueRepository = physiqueRepository;
    }

    @Override
    public PhysiqueDTO save(PhysiqueDTO dto) {
        List<String> errors = PhysiqueValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("l'objet est invalide {}",  dto );
            throw new InvalidEntityException("L'objet est invalide {}" , errors);
        }
        return PhysiqueDTO.toEntityDTO(physiqueRepository.save(PhysiqueDTO.toEntity(dto)));
    }

    @Override
    public PhysiqueDTO findById(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw new EntityNotFoundException("Impossible de trouver un client physique avec un id null");
        }
        return physiqueRepository.findById(id).map(PhysiqueDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucun client physique n'a été trouvé avec l'id:" + id);
        });
    }

    @Override
    public List<PhysiqueDTO> findAll() {
        return physiqueRepository.findAll().stream().map(PhysiqueDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public PhysiqueDTO findByEmail(String email) {
        if(email == null){
            log.info("L'email fournit est vide");
            throw new EntityNotFoundException("Impossible de trouver un client Physique avec un email null");
        }
        return physiqueRepository.findByEmail(email).map(PhysiqueDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucune client physique n'a été trouvé avec cet email:" + email);
        });
    }

    @Override
    public PhysiqueDTO findByNom(String nom) {
        if(nom == null){
            log.info("le nom fournit est null");
            throw new EntityNotFoundException("Impossible de trouver un client Physique avec un nom null");
        }
        return physiqueRepository.findByNom(nom).map(PhysiqueDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucun client Physique n'a été trouvé avec le nom: " + nom);
        });
    }

    @Override
    public void delete(Integer id) {
      physiqueRepository.deleteById(id);
    }
}
