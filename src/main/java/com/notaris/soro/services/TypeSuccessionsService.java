package com.notaris.soro.services;

import com.notaris.soro.dto.admin.TypeSuccessionsDTO;
import com.notaris.soro.dto.admin.VilleDTO;

import java.util.List;

public interface TypeSuccessionsService {
    TypeSuccessionsDTO save(TypeSuccessionsDTO dto);
    TypeSuccessionsDTO findById(Integer id);
    List<TypeSuccessionsDTO> findAll();
    TypeSuccessionsDTO update(Integer id, TypeSuccessionsDTO dto);
    void delete(Integer id);
}
