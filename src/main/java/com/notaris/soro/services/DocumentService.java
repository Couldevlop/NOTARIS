package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.models.Documents;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


public interface DocumentService {
    DocumentsDTO saveFile(MultipartFile file);
    DocumentsDTO getFile(Integer fileId);
    List<DocumentsDTO> getFiles();

}
