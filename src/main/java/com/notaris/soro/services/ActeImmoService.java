package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ActeImmoService {
    ActeImmobilierDTO save(ActeImmobilierDTO dto);
    ActeImmobilierDTO findById(Integer id);
    List<ActeImmobilierDTO> findAll();
    ActeImmobilierDTO save(Integer idDossier,  MultipartFile files) throws IOException;
    List<DocumentsDTO> findActeImmoDocByIddossier(Integer id);
    void delete(Integer id);


}
