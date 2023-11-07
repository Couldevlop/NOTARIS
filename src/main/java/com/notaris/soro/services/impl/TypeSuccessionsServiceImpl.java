package com.notaris.soro.services.impl;

import com.notaris.soro.dto.admin.TypeSuccessionsDTO;
import com.notaris.soro.exceptions.EntityAlreadyExistException;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.models.admin.TypeSuccessions;
import com.notaris.soro.repositories.TypeSuccessionsRepository;
import com.notaris.soro.services.TypeSuccessionsService;
import com.notaris.soro.validators.TypeSuccessionsValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TypeSuccessionsServiceImpl implements TypeSuccessionsService {
    private final TypeSuccessionsRepository typeSuccessionsRepository;

    public TypeSuccessionsServiceImpl(TypeSuccessionsRepository typeSuccessionsRepository) {
        this.typeSuccessionsRepository = typeSuccessionsRepository;
    }


    @Override
    public TypeSuccessionsDTO save(TypeSuccessionsDTO dto) {
        List<String> errors = TypeSuccessionsValidator.validate(dto);
        if(dto ==  null){
            log.info("l'objet est null");
            throw new EntityAlreadyExistException("Objet est null");
        }if(typeSuccessionsRepository.findByLibelle(dto.getLibelle()) != null){
            throw new EntityAlreadyExistException("Un type de sucession existe avec ce nom " + dto.getLibelle());
        }
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Objet fourni est invalide", errors);
        }
        return TypeSuccessionsDTO.toEntityDTO(typeSuccessionsRepository.save(TypeSuccessionsDTO.toEntity(dto)));
    }

    @Override
    public TypeSuccessionsDTO findById(Integer id) {
        if(id == null){
            log.info("id est null");
            throw  new EntityNotFoundException("Impossible d'avoir un resultat avec un id null");
        }
        return typeSuccessionsRepository.findById(id).map(TypeSuccessionsDTO::toEntityDTO).orElseThrow(()->{
            throw new EntityNotFoundException("Aucun resultat trouvé avec l'id " + id);
        });
    }

    @Override
    public List<TypeSuccessionsDTO> findAll() {
        return typeSuccessionsRepository.findAll().stream().map(TypeSuccessionsDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public TypeSuccessionsDTO update(Integer id, TypeSuccessionsDTO dto) {
        if(id == null){
            log.info("id est null");
            throw  new EntityNotFoundException("Impossible d'avoir un resultat avec un id null");
        }
        if(typeSuccessionsRepository.existsById(id) == false){
            throw new EntityNotFoundException("Aucun objet n'a été trouvé avec l'id " + id);
        }
        TypeSuccessions successions = typeSuccessionsRepository.findById(id).get();
        successions.setLibelle(dto.getLibelle());
        return TypeSuccessionsDTO.toEntityDTO(typeSuccessionsRepository.save(successions));
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.info("id est null");
            throw  new EntityNotFoundException("Impossible d'avoir un resultat avec un id null");
        }
        typeSuccessionsRepository.deleteById(id);
    }
}
