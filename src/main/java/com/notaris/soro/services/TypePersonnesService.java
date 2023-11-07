package com.notaris.soro.services;

import com.notaris.soro.dto.admin.TypePersonnesDTO;
import com.notaris.soro.dto.admin.TypeSuccessionsDTO;

import java.util.List;

public interface TypePersonnesService {
    TypePersonnesDTO save(TypePersonnesDTO dto);
    TypePersonnesDTO findById(Integer id);
    List<TypePersonnesDTO> findAll();
    TypePersonnesDTO update(Integer id, TypePersonnesDTO dto);
    void delete(Integer id);
}
