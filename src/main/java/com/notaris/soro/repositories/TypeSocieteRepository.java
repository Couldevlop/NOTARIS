package com.notaris.soro.repositories;

import com.notaris.soro.models.admin.TypeSociete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeSocieteRepository extends JpaRepository<TypeSociete, Integer> {
    TypeSociete findByLibelle(String sigle);
}
