package com.notaris.soro.services.impl;

import com.notaris.soro.dto.MoralDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.repositories.MoralRepository;
import com.notaris.soro.services.MoralService;
import com.notaris.soro.validators.MoralValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j

public class MoralServiceImpl implements MoralService {
    private final MoralRepository moralRepository;

    public MoralServiceImpl(MoralRepository moralRepository) {
        this.moralRepository = moralRepository;
    }

    @Override
    public MoralDTO save(MoralDTO dto) {
        List<String> errors = MoralValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("l'objet fournit est null");
            throw new InvalidEntityException("L'objet est invalide {}");
        }
        return MoralDTO.toEntityDTO(moralRepository.save(MoralDTO.toEntity(dto)));
    }

    @Override
    public MoralDTO findById(Integer id) {
        if(id == null){
            log.info("l'id fournit est null");
            throw new EntityNotFoundException("Impossible de trouver un client Moral avec un id null");
        }
        return moralRepository.findById(id).map(MoralDTO::toEntityDTO).orElseThrow(()->{
            throw  new EntityNotFoundException("Aucun client n'a été trouvé avec l'id: " + id);
        });
    }

    @Override
    public List<MoralDTO> findAll() {
        return moralRepository.findAll().stream().map(MoralDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public MoralDTO findByEmail(String activite) {
        if(activite == null){
            log.info("l'id fournit est null");
            throw new EntityNotFoundException("Impossible de trouver un client Moral avec l'email null");
        }
        return moralRepository.findByActivite(activite).map(MoralDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucun client Moral n'a été trouvé avec l'eamail suivant: " + activite);
        });
    }

    @Override
    public MoralDTO findByNom(String sigle) {
        if(sigle == null){
            log.info("l'id fournit est null");
            throw new EntityNotFoundException("Impossible de trouver un client Moral avec le nom null");
        }
        return moralRepository.findBySigle(sigle).map(MoralDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucun client Moral n'a été trouvé avec le nom suivant: " + sigle);
        });
    }

    @Override
    public void delete(Integer id) {
     moralRepository.deleteById(id);
    }
}
