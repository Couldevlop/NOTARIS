package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.TypeDocumentDTO;

import java.util.List;

public interface TypeDocumentService {
    TypeDocumentDTO save(TypeDocumentDTO dto);
    TypeDocumentDTO findById(Integer id);
    List<TypeDocumentDTO> findAll();
    void delete(Integer id);
}
