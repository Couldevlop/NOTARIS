package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.MoralDTO;
import com.notaris.soro.models.Moral;

import java.util.List;
import java.util.Optional;

public interface MoralService {
    MoralDTO save(MoralDTO dto);
    MoralDTO findById(Integer id);
    List<MoralDTO> findAll(MoralDTO dto);
    MoralDTO findByEmail(String email);
    MoralDTO findByNom(String nom);
    void delete(Integer id);
}
