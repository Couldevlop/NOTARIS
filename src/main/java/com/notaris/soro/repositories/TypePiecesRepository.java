package com.notaris.soro.repositories;

import com.notaris.soro.models.admin.TypePieces;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypePiecesRepository extends JpaRepository<TypePieces, Integer> {
    TypePieces findByLibelle(String libelle);
}
