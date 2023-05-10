package com.notaris.soro.services;

import com.notaris.soro.dto.CommunauteDTO;

import java.util.List;

public interface CommunauteService {
    CommunauteDTO save(CommunauteDTO dto);
    CommunauteDTO findById(Integer id);
    List<CommunauteDTO> findAll();
    CommunauteDTO findByIntitule(String intitule);
    void delete(Integer id);
}
