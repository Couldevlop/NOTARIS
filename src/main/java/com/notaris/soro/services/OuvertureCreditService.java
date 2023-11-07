package com.notaris.soro.services;

import com.notaris.soro.dto.OuvertureCreditDTO;
import com.notaris.soro.dto.PhysiqueDTO;

import java.util.List;

public interface OuvertureCreditService {
    OuvertureCreditDTO save(OuvertureCreditDTO dto);
    OuvertureCreditDTO findById(Integer id);
    List<OuvertureCreditDTO> findAll();
    void delete(Integer id);
}
