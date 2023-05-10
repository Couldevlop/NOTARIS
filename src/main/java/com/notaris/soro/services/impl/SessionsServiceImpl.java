package com.notaris.soro.services.impl;

import com.notaris.soro.dto.BanqueDTO;
import com.notaris.soro.dto.SessionsDTO;
import com.notaris.soro.services.SessionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SessionsServiceImpl implements SessionsService {
    @Override
    public SessionsDTO save(BanqueDTO dto) {
        return null;
    }

    @Override
    public SessionsDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<SessionsDTO> findAll() {
        return null;
    }

    @Override
    public SessionsDTO findBySigle(String intitule) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
