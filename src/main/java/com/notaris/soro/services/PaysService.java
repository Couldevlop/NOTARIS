package com.notaris.soro.services;

import com.notaris.soro.dto.admin.PaysDTO;
import com.notaris.soro.dto.admin.VilleDTO;

import java.util.List;

public interface PaysService {
    PaysDTO save(PaysDTO dto);
    PaysDTO findById(Integer id);
    List<PaysDTO> findAll();
    PaysDTO update(Integer id, PaysDTO dto);
    void delete(Integer id);
}
