package com.notaris.soro.services;

import com.notaris.soro.dto.SucessionDTO;

import java.util.List;

public interface SessionsService {
    SucessionDTO save(SucessionDTO dto);
    SucessionDTO findById(Integer id);
    List<SucessionDTO> findAll();
    SucessionDTO findByIntitule(String intitule);
    void delete(Integer id);
}
