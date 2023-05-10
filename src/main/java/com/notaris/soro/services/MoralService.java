package com.notaris.soro.services;

import com.notaris.soro.dto.MoralDTO;

import java.util.List;

public interface MoralService {
    MoralDTO save(MoralDTO dto);
    MoralDTO findById(Integer id);
    List<MoralDTO> findAll();
    MoralDTO findByEmail(String email);
    MoralDTO findByNom(String nom);
    void delete(Integer id);
}
