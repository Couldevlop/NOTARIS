package com.notaris.soro.services;

import com.notaris.soro.dto.BanqueDTO;

public interface BanqueService {
    BanqueDTO save(BanqueDTO dto);
    BanqueDTO findBy(Integer id);
    BanqueDTO findALL(BanqueDTO dto);
    BanqueDTO findByNom(BanqueDTO dto);
    void delete(Integer id);
}
