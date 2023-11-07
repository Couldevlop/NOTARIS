package com.notaris.soro.services.impl;

import com.notaris.soro.dto.OuvertureCreditDTO;
import com.notaris.soro.dto.PhysiqueDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.OuvertureCredit;
import com.notaris.soro.repositories.OuvertureCreditRepository;
import com.notaris.soro.services.OuvertureCreditService;
import com.notaris.soro.validators.OuvertureCreditValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OuvertureCreditServiceImpl implements OuvertureCreditService {
    private final OuvertureCreditRepository ouvertureCreditRepository;


    public OuvertureCreditServiceImpl(OuvertureCreditRepository ouvertureCreditRepository) {
        this.ouvertureCreditRepository = ouvertureCreditRepository;

    }

    @Override
    public OuvertureCreditDTO save(OuvertureCreditDTO dto) {
        List<String> errors = OuvertureCreditValidator.Validation(dto);
        if(dto == null){
            log.info("l'objet est null {] ", dto );
            throw new InvalidEntityException("l'objet est invalide", errors);
        }
        return OuvertureCreditDTO.toEntityDTO(ouvertureCreditRepository.save(OuvertureCreditDTO.toEnity(dto)));
    }

    @Override
    public OuvertureCreditDTO findById(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw new EntityNotFoundException("impossible de trouver un enregistrement avec un id null");
        }
        return ouvertureCreditRepository.findById(id).map(OuvertureCreditDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("impossible de trouver un enregistrement pour cet id: " + id);
        });
    }

    @Override
    public List<OuvertureCreditDTO> findAll() {
        return ouvertureCreditRepository.findAll().stream().map(OuvertureCreditDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw new EntityNotFoundException("impossible de trouver un enregistrement avec un id null");
        }
      ouvertureCreditRepository.deleteById(id);
    }
}
