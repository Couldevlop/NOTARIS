package com.notaris.soro.services;

import com.notaris.soro.dto.TypeSocieteDTO;
import com.notaris.soro.dto.admin.VilleDTO;

import java.util.List;

public interface VilleService {
    VilleDTO save(VilleDTO dto);
    VilleDTO findById(Integer id);
    List<VilleDTO> findAll();
    VilleDTO update(Integer id, VilleDTO dto);
    void delete(Integer id);
}
