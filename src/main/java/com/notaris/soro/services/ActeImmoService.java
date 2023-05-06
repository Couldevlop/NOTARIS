package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;

import java.util.List;

public interface ActeImmoService {
    ActeImmobilierDTO save(ActeImmobilierDTO dto);
    ActeImmobilierDTO findById(Integer id);
    List<ActeImmobilierDTO> findAll();
    DocumentsDTO save(Integer idDossier, DocumentsDTO dto);
    void delete(Integer id);

}
