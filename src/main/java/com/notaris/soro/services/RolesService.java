package com.notaris.soro.services;

import com.notaris.soro.dto.admin.RolesDTO;

import java.util.List;

public interface RolesService {
    RolesDTO save(RolesDTO dto);
    RolesDTO findById(Integer id);
    List<RolesDTO> findAll();
    void delete(Integer id);
}
