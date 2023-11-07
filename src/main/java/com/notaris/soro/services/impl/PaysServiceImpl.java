package com.notaris.soro.services.impl;

import com.notaris.soro.dto.admin.PaysDTO;
import com.notaris.soro.exceptions.EntityAlreadyExistException;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.admin.Pays;
import com.notaris.soro.repositories.PaysRepository;
import com.notaris.soro.services.PaysService;
import com.notaris.soro.validators.PaysValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PaysServiceImpl implements PaysService {
    private final PaysRepository paysRepository;

    public PaysServiceImpl(PaysRepository paysRepository) {
        this.paysRepository = paysRepository;
    }

    @Override
    public PaysDTO save(PaysDTO dto) {
        List<String> errors = PaysValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("Objet invalide {}", dto);
            throw new InvalidEntityException("L'objet fourni est invalide", errors);
        }
        if(paysRepository.findByNom(dto.getNom()) !=null){
            throw new EntityAlreadyExistException("Un pays existe avec ce nom: " + dto.getNom(), errors);
        }
        return PaysDTO.toEntityDTO(paysRepository.save(PaysDTO.toEntity(dto)));
    }

    @Override
    public PaysDTO findById(Integer id) {
        if(id == null){
            log.info("l'id fourni est null");
            throw new EntityNotFoundException("Impossible de trouver un resultat avec un id null");
        }if(paysRepository.existsById(id) == true){
            throw new EntityAlreadyExistException("Un pays existe déjà");
        }
        return paysRepository.findById(id).map(PaysDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucun resultat n'a été trouvé avec l'id " + id);
        });
    }

    @Override
    public List<PaysDTO> findAll() {
        return paysRepository.findAll().stream().map(PaysDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public PaysDTO update(Integer id, PaysDTO dto) {
        if(id == null){
            log.info("l'id fourni est null");
            throw new EntityNotFoundException("Impossible de trouver un resultat avec un id null");
        }if(paysRepository.existsById(id) == false){
            throw new EntityNotFoundException("Aucun resultat n'a été retrouvé avec l'id  " + id);
        }
        Pays pays = paysRepository.findById(id).get();
         pays.setNom(dto.getNom());
        return PaysDTO.toEntityDTO(paysRepository.save(pays));
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.info("l'id fourni est null");
            throw new EntityNotFoundException("Impossible de trouver un resultat avec un id null");
        }
     paysRepository.deleteById(id);
    }
}
