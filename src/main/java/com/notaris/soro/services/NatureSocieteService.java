package com.notaris.soro.services;

import com.notaris.soro.dto.NatureSocieteDTO;

import java.util.List;

public interface NatureSocieteService {
    NatureSocieteDTO save(NatureSocieteDTO dto);
    NatureSocieteDTO findById(Integer id);
    List<NatureSocieteDTO> findAll();
    NatureSocieteDTO findByLibelle(String sigle);
    NatureSocieteDTO update(Integer id, NatureSocieteDTO dto);
    void delete(Integer id);
}
