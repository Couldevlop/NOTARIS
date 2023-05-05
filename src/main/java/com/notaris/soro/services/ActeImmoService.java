package com.notaris.soro.services;

import com.notaris.soro.dto.ActeImmobilierDTO;

public interface ActeImmoService {
    ActeImmobilierDTO save(ActeImmobilierDTO dto);
    ActeImmobilierDTO findBy(Integer id);
    ActeImmobilierDTO findALL(ActeImmobilierDTO dto);
    void delete(Integer id);

}
