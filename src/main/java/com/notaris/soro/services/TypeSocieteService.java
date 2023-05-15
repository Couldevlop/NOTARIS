package com.notaris.soro.services;

import com.notaris.soro.dto.NatureSocieteDTO;
import com.notaris.soro.dto.TypeSocieteDTO;

import java.util.List;

public interface TypeSocieteService {
    TypeSocieteDTO save(TypeSocieteDTO dto);
    TypeSocieteDTO findById(Integer id);
    List<TypeSocieteDTO> findAll();
    TypeSocieteDTO findByLibelle(String sigle);
    TypeSocieteDTO update(Integer id, TypeSocieteDTO dto);
    void delete(Integer id);
}
