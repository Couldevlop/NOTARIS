package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;
import com.notaris.soro.dto.MoralDTO;

public interface MoralService {
    MoralDTO save(MoralDTO dto);
    MoralDTO findBy(Integer id);
    MoralDTO findALL(MoralDTO dto);
    void delete(Integer id);
}
