package com.notaris.soro.services.impl;

import com.notaris.soro.dto.TypeSocieteDTO;
import com.notaris.soro.exceptions.EntityAlreadyExistException;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.repositories.TypeSocieteRepository;
import com.notaris.soro.services.TypeSocieteService;
import com.notaris.soro.validators.TypeSocieteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TypeSocieteServiceImpl implements TypeSocieteService {
    private final TypeSocieteRepository typeSocieteRepository;

    public TypeSocieteServiceImpl(TypeSocieteRepository typeSocieteRepository) {
        this.typeSocieteRepository = typeSocieteRepository;
    }

    @Override
    public TypeSocieteDTO save(TypeSocieteDTO dto) {
        List<String> errors = TypeSocieteValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("l'objet fourni est invalide");
            throw new InvalidEntityException("Invalide objet {}" + dto , errors );
        }if(typeSocieteRepository.findByLibelle(dto.getLibelle()) == null){
            return TypeSocieteDTO.toEntityDTO(typeSocieteRepository.save(TypeSocieteDTO.toEntity(dto)));
        }else {
            log.info("Un ype de societe existe déjà avec cette denomination: " + dto.getLibelle());
            throw new EntityAlreadyExistException("Un ype de societe existe déjà avec cette denomination: " + dto.getLibelle());
        }
    }

    @Override
    public TypeSocieteDTO findById(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw new EntityNotFoundException("L'id " + id + "fourni est null");
        }
        return typeSocieteRepository.findById(id).map(TypeSocieteDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucun type de societé n'a été trouvé dans la BD avec l'id " + id);
        });
    }

    @Override
    public List<TypeSocieteDTO> findAll() {
        return typeSocieteRepository.findAll().stream().map(TypeSocieteDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public TypeSocieteDTO findObjectByLibelle(String libelle) {
        if(libelle == null){
            log.info("Le libellé est null");
            throw new EntityNotFoundException("Impossible de trouver dans la BD un type de société avec un libellé null");
        }if(typeSocieteRepository.findByLibelle(libelle) == null){
            throw new EntityNotFoundException("Aucun type de societé n'a été trouvé dans la BD avec l'id " + libelle);
        }
        return TypeSocieteDTO.toEntityDTO(typeSocieteRepository.findByLibelle(libelle));
    }

    @Override

    public TypeSocieteDTO update(Integer id, TypeSocieteDTO dto) {
        //--------validation des parametres-----------
        if(id == null){
            log.info("l'id est null");
            throw new EntityNotFoundException("L'id " + id + "fourni est null");
        }if(dto == null){
            List<String> errors = TypeSocieteValidator.validate(dto);
            log.info("l'objet fourni est invalide");
            throw new InvalidEntityException("Invalide objet {}" + dto , errors );
        }

        //--------mise à jour des données-----
        TypeSocieteDTO lastObject = findById(id);
        lastObject.setDescription(dto.getDescription());
        lastObject.setLibelle(dto.getLibelle());
        return TypeSocieteDTO.toEntityDTO(typeSocieteRepository.save(TypeSocieteDTO.toEntity(lastObject)));

    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw new EntityNotFoundException("L'id " + id + "fourni est null");
        }
        typeSocieteRepository.deleteById(id);
    }
}
