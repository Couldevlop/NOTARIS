package com.notaris.soro.services;

import com.notaris.soro.dto.PhysiqueDTO;

import java.util.List;

public interface PhysiqueService {
    PhysiqueDTO save(PhysiqueDTO dto);
    PhysiqueDTO findById(Integer id);
    List<PhysiqueDTO> findAll();

    PhysiqueDTO findByEmail(String email);

    PhysiqueDTO findByNom(String nom);
    void delete(Integer id);
}
