package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.dto.ModificationDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ModificationService {
    ModificationDTO save(ModificationDTO dto);
    ModificationDTO findById(Integer id);
    List<ModificationDTO> findAll();
    ModificationDTO save(Integer idDossier,  MultipartFile files) throws IOException;
    List<DocumentsDTO> findActeImmoDocByIddossier(Integer id);
    void delete(Integer id);

}
