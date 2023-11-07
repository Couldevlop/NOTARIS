package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.CommunauteDTO;
import com.notaris.soro.dto.DocumentsCommunauteDTO;
import com.notaris.soro.dto.DocumentsDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CommunauteService {
    CommunauteDTO save(CommunauteDTO dto);
    CommunauteDTO findById(Integer id);
    List<CommunauteDTO> findAll();
    CommunauteDTO findByIntitule(String intitule);
    CommunauteDTO save(Integer idDossier, MultipartFile files) throws IOException;
    List<DocumentsCommunauteDTO> findCommunauteDocByIdDossier(Integer id);
    void delete(Integer id);
}
