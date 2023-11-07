package com.notaris.soro.services.impl;

import com.notaris.soro.dto.admin.TypePersonnesDTO;
import com.notaris.soro.exceptions.EntityAlreadyExistException;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.admin.TypePersonnes;
import com.notaris.soro.repositories.TypePersonnesRepository;
import com.notaris.soro.services.TypePersonnesService;
import com.notaris.soro.validators.TypePersonnesValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TypePersonnesServiceImpl implements TypePersonnesService {

    private final TypePersonnesRepository typePersonnesRepository;

    public TypePersonnesServiceImpl(TypePersonnesRepository typePersonnesRepository) {
        this.typePersonnesRepository = typePersonnesRepository;
    }

    @Override
    public TypePersonnesDTO save(TypePersonnesDTO dto) {
        List<String> errors = TypePersonnesValidator.validate(dto);
        if(dto == null){
            log.info("objet ivalide");
            throw new InvalidEntityException("Objet fourni est null");
        }if(typePersonnesRepository.findTypePersonnesByNom(dto.getNom()) != null){
            throw new EntityAlreadyExistException("Un type de personnes avec cette denomination " + dto.getNom() + " existe");
        }if(!errors.isEmpty()){
            log.info("Objet invalide");
            throw new InvalidEntityException("Objet fourni est invalid", errors);
        }
        return TypePersonnesDTO.toEntityDTO(typePersonnesRepository.save(TypePersonnesDTO.toEntity(dto)));
    }

    @Override
    public TypePersonnesDTO findById(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw  new EntityNotFoundException("Impossible d'avoir un resultat avec un id null");
        }
        return typePersonnesRepository.findById(id).map(TypePersonnesDTO::toEntityDTO).orElseThrow((()->{
            throw  new EntityNotFoundException("Aucun resultat n'a été trouvé pour l'id " + id);
        }));
    }

    @Override
    public List<TypePersonnesDTO> findAll() {
        return typePersonnesRepository.findAll().stream().map(TypePersonnesDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public TypePersonnesDTO update(Integer id, TypePersonnesDTO dto) {
        if(id == null){
            log.info("l'id est null");
            throw  new EntityNotFoundException("Impossible d'avoir un resultat avec un id null");
        }if(typePersonnesRepository.existsById(id) == false){
            throw  new EntityNotFoundException("Aucun resultat n'a été trouvé pour l'id " + id);
        }
        TypePersonnes personnes = typePersonnesRepository.findById(id).get();
        personnes.setNom(dto.getNom());
        return TypePersonnesDTO.toEntityDTO(typePersonnesRepository.save(personnes)) ;
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.info("l'id est null");
            throw  new EntityNotFoundException("Impossible d'avoir un resultat avec un id null");
        }
      typePersonnesRepository.deleteById(id);
    }
}
