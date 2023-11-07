package com.notaris.soro.services;

import com.notaris.soro.dto.admin.TypePiecesDTO;
import com.notaris.soro.dto.admin.VilleDTO;
import com.notaris.soro.models.admin.TypePieces;

import java.util.List;

public interface TypePiecesService {
    TypePiecesDTO save(TypePiecesDTO dto);
    TypePiecesDTO findById(Integer id);
    List<TypePiecesDTO> findAll();
    TypePiecesDTO update(Integer id, TypePiecesDTO dto);
    void delete(Integer id);
}
