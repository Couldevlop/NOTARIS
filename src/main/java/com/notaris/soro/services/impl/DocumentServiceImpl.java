package com.notaris.soro.services.impl;

import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.dto.MoralDTO;
import com.notaris.soro.exceptions.EntityNotFoundException;
import com.notaris.soro.exceptions.InvalidEntityException;
import com.notaris.soro.repositories.DocumentRepository;
import com.notaris.soro.services.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private DocumentRepository documentRepository;
    @Override
    public DocumentsDTO save(DocumentsDTO dto) {
        if(dto == null){
            log.info("l'objet est invalid");
            throw new InvalidEntityException("L'objet fournit est invalide");
        }
        return DocumentsDTO.toEntityDTO(documentRepository.save(DocumentsDTO.toEntity(dto)));
    }

    @Override
    public DocumentsDTO findById(Integer id) {
        if(id == null){
            log.info("l'id fournit est null");
            throw new EntityNotFoundException("Impossible de trouver un client Moral avec un id null");
        }
        return documentRepository.findById(id).map(DocumentsDTO::toEntityDTO).orElseThrow(()->{
            throw  new EntityNotFoundException("Aucun client n'a été trouvé avec l'id: " + id);
        });
    }

    @Override
    public List<DocumentsDTO> findAll(DocumentsDTO dto) {
        return documentRepository.findAll().stream().map(DocumentsDTO::toEntityDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
         documentRepository.deleteById(id);
    }


}
