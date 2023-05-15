package com.notaris.soro.services.impl;

import com.notaris.soro.dto.SucessionDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.repositories.SucessionRepository;
import com.notaris.soro.services.SessionsService;
import com.notaris.soro.validators.SucessionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SessionsServiceImpl implements SessionsService {
    private final SucessionRepository sucessionRepository;

    public SessionsServiceImpl(SucessionRepository sucessionRepository) {
        this.sucessionRepository = sucessionRepository;
    }


    @Override
    public SucessionDTO save(SucessionDTO dto) {
        List<String> errors = SucessionValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("Objet invalid {}", dto);
            throw new InvalidEntityException("L'objet fourni est invalide", errors);
        }
        return SucessionDTO.toEntityDTO(sucessionRepository.save(SucessionDTO.toEntity(dto)));
    }

    @Override
    public SucessionDTO findById(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw new EntityNotFoundException("Impossible de trouver une liquidation de session pour un id null");
        }
        return sucessionRepository.findById(id).map(SucessionDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucune liquidation de session ne correspond à l'id" + id);
        });
    }

    @Override
    public List<SucessionDTO> findAll() {
        return sucessionRepository.findAll().stream().map(SucessionDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public SucessionDTO findByIntitule(String intitule) {
        if(intitule == null){
            log.info("l'intitulé est null");
            throw new EntityNotFoundException("Impossible de trouver une liquidation correspondant à l'intitule " + intitule);
        }
        return sucessionRepository.findByIntitule(intitule).map(SucessionDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucune liquidation de session ne correspond à l'intitul" + intitule);
        });
    }

    @Override
    public void delete(Integer id) {
       sucessionRepository.deleteById(id);
    }
}
