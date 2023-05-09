package com.notaris.soro.services.impl;

import com.notaris.soro.dto.TypeDocumentDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.repositories.TypeDocumentRepository;
import com.notaris.soro.services.TypeDocumentService;
import com.notaris.soro.validators.TypeDocumentValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TypeDocumentServiceImpl implements TypeDocumentService {
    private final TypeDocumentRepository typeDocumentRepository;


    @Override
    public TypeDocumentDTO save(TypeDocumentDTO dto) {
        // verification de la validité de l'objet

        List<String> errors = TypeDocumentValidator.validate(dto);
        if(!errors.isEmpty()){
            log.info("l'objet que vous voulez enregistrer est introuve {}", dto);
        }
        return TypeDocumentDTO.toEntityDTO(typeDocumentRepository.save(TypeDocumentDTO.toEntity(dto)));

    }

    @Override
    public TypeDocumentDTO findById(Integer id) {
        if(id == null){
            return null;
        }
    return  typeDocumentRepository.findById(id).map(TypeDocumentDTO::toEntityDTO).orElseThrow(()->{
        throw new EntityNotFoundException("le type de document avec l'id:" + id + "est introuvable");
    });

    }

    @Override
    public List<TypeDocumentDTO> findAll() {
        return typeDocumentRepository.findAll().stream().map(TypeDocumentDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            return;
        }
     typeDocumentRepository.deleteById(id);
    }
}
