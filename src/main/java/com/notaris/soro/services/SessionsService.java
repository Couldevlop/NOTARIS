package com.notaris.soro.services;

import com.notaris.soro.dto.BanqueDTO;
import com.notaris.soro.dto.SessionsDTO;

import java.util.List;

public interface SessionsService {
    SessionsDTO save(BanqueDTO dto);
    SessionsDTO findById(Integer id);
    List<SessionsDTO> findAll();
    SessionsDTO findBySigle(String intitule);
    void delete(Integer id);
}
