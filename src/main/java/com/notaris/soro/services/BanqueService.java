package com.notaris.soro.services;

import com.notaris.soro.dto.BanqueDTO;

import java.util.List;
import java.util.Optional;

public interface BanqueService {
    BanqueDTO save(BanqueDTO dto);
    BanqueDTO findById(Integer id);
    List<BanqueDTO> findAll();
    BanqueDTO findBySigle(String sigle);
    void delete(Integer id);
}
