package com.notaris.soro.services.impl;

import com.notaris.soro.dto.NatureSocieteDTO;
import com.notaris.soro.dto.TypeSocieteDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.repositories.NatureSocieteRepository;
import com.notaris.soro.services.NatureSocieteService;
import com.notaris.soro.validators.NatureSocieteValidator;
import com.notaris.soro.validators.TypeSocieteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NatureSocieteServiceImpl implements NatureSocieteService {
    private final NatureSocieteRepository natureSocieteRepository;

    public NatureSocieteServiceImpl(NatureSocieteRepository natureSocieteRepository) {
        this.natureSocieteRepository = natureSocieteRepository;
    }

    @Override
    public NatureSocieteDTO save(NatureSocieteDTO dto) {
        List<String> errors = NatureSocieteValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("l'objet fourni est invalide");
            throw new InvalidEntityException("Invalide objet {}" + dto , errors );
        }
        return NatureSocieteDTO.toEntityDTO(natureSocieteRepository.save(NatureSocieteDTO.toEntity(dto)));
    }

    @Override
    public NatureSocieteDTO findById(Integer id) {
        if(id == null){
            log.info("L'id fourni est null");
            throw  new EntityNotFoundException("Impossible de trouver dans la BD une nature de société avec l'id " + id);
        }
        return natureSocieteRepository.findById(id).map(NatureSocieteDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucune donnée ne correspondant à l'id " + id + "dans la BD");
        });
    }

    @Override
    public List<NatureSocieteDTO> findAll() {
        return natureSocieteRepository.findAll().stream().map(NatureSocieteDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public NatureSocieteDTO findByLibelle(String libelle) {
        if(libelle == null){
            log.info("Le libellé est null");
            throw new EntityNotFoundException("Impossible de trouver dans la BD un type de société avec un libellé null");
        }
        return natureSocieteRepository.findByLibelle(libelle).map(NatureSocieteDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucun donnée n'a été trouvées dans la BD correspondant au libellé " + libelle);
        });
    }

    @Override
    public NatureSocieteDTO update(Integer id, NatureSocieteDTO dto) {
        //--------validation des parametres-----------
        if(id == null){
            log.info("l'id est null");
            throw new EntityNotFoundException("L'id " + id + "fourni est null");
        }if(dto == null){
            List<String> errors = NatureSocieteValidator.validate(dto);
            log.info("l'objet fourni est invalide");
            throw new InvalidEntityException("Invalide objet {}" + dto , errors );
        }

        //--------mise à jour des données-----
        NatureSocieteDTO lastObject = findById(id);
        lastObject.setDescription(dto.getDescription());
        lastObject.setLibelle(dto.getLibelle());
        return NatureSocieteDTO.toEntityDTO(natureSocieteRepository.save(NatureSocieteDTO.toEntity(lastObject)));
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw new EntityNotFoundException("L'id " + id + "fourni est null");
        }
        natureSocieteRepository.deleteById(id);
    }
}
