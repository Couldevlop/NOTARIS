package com.notaris.soro.services.impl;

import com.notaris.soro.dto.CommunauteDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.repositories.CommunauteRepository;
import com.notaris.soro.services.CommunauteService;
import com.notaris.soro.validators.CommunauteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommunauteServiceImpl implements CommunauteService {

    private final CommunauteRepository communauteRepository;

    public CommunauteServiceImpl(CommunauteRepository communauteRepository) {
        this.communauteRepository = communauteRepository;
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
            throw new EntityNotFoundException("Aucune liquidation avec l'intitulé: " + intitule  + "existe dans la BD");
        });
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
