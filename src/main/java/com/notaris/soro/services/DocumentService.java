package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;

public interface DocumentService {
    DocumentsDTO save(DocumentsDTO dto);
    DocumentsDTO findBy(Integer id);
    DocumentsDTO findALL(DocumentsDTO dto);
    void delete(Integer id);
}
