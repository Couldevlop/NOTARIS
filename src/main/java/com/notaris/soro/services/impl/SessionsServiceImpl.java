package com.notaris.soro.services.impl;

import com.notaris.soro.dto.SessionsDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.repositories.SessionsRepository;
import com.notaris.soro.services.SessionsService;
import com.notaris.soro.validators.SessionsValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SessionsServiceImpl implements SessionsService {
    private final SessionsRepository sessionsRepository;

    public SessionsServiceImpl(SessionsRepository sessionsRepository) {
        this.sessionsRepository = sessionsRepository;
    }


    @Override
    public SessionsDTO save(SessionsDTO dto) {
        List<String> errors = SessionsValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("Objet invalid {}", dto);
            throw new InvalidEntityException("L'objet fourni est invalide", errors);
        }
        return SessionsDTO.toEntityDTO(sessionsRepository.save(SessionsDTO.toEntity(dto)));
    }

    @Override
    public SessionsDTO findById(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw new EntityNotFoundException("Impossible de trouver une liquidation de session pour un id null");
        }
        return sessionsRepository.findById(id).map(SessionsDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucune liquidation de session ne correspond à l'id" + id);
        });
    }

    @Override
    public List<SessionsDTO> findAll() {
        return sessionsRepository.findAll().stream().map(SessionsDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public SessionsDTO findByIntitule(String intitule) {
        if(intitule == null){
            log.info("l'intitulé est null");
            throw new EntityNotFoundException("Impossible de trouver une liquidation correspondant à l'intitule " + intitule);
        }
        return sessionsRepository.findByIntitule(intitule).map(SessionsDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucune liquidation de session ne correspond à l'intitul" + intitule);
        });
    }

    @Override
    public void delete(Integer id) {
       sessionsRepository.deleteById(id);
    }
}
