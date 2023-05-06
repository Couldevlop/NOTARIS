package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DocumentService {
    DocumentsDTO save(DocumentsDTO dto);
    DocumentsDTO findById(Integer id);
    List<DocumentsDTO> findAll(DocumentsDTO dto);
    void delete(Integer id);

}
