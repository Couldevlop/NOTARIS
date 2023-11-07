package com.notaris.soro.services;

import com.notaris.soro.dto.DocumentsSuccesionDTO;
import com.notaris.soro.dto.SuccessionDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SuccessionService {
    SuccessionDTO save(SuccessionDTO dto);
    SuccessionDTO findById(Integer id);
    List<SuccessionDTO> findAll();
    SuccessionDTO findByIntitule(String intitule);
    SuccessionDTO save(Integer idDossier, MultipartFile files) throws IOException;
    List<DocumentsSuccesionDTO> findSuccessionByIdDossier(Integer id);
    void delete(Integer id);
}
