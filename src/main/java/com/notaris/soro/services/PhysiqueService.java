package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.PhysiqueDTO;

public interface PhysiqueService {
    PhysiqueDTO save(PhysiqueDTO dto);
    PhysiqueDTO findBy(Integer id);
    PhysiqueDTO findALL(PhysiqueDTO dto);
    void delete(Integer id);
}
