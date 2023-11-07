package com.notaris.soro.services;

import com.notaris.soro.dto.CreationDTO;
import com.notaris.soro.dto.MoralDTO;

import java.util.List;

public interface ConstitutionService {
    CreationDTO save(CreationDTO dto);
    CreationDTO update(Integer id, CreationDTO dto);
    CreationDTO findById(Integer id);
    List<CreationDTO> findAll();
    CreationDTO findByIntitule(String email);
    void delete(Integer id);
}
