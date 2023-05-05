package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.TypeDocumentDTO;

public interface TypeDocumentService {
    TypeDocumentDTO save(TypeDocumentDTO dto);
    TypeDocumentDTO findBy(Integer id);
    TypeDocumentDTO findALL(TypeDocumentDTO dto);
    void delete(Integer id);
}
