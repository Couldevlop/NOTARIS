package com.notaris.soro.repositories;

import com.notaris.soro.models.admin.TypeSuccessions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeSuccessionsRepository extends JpaRepository<TypeSuccessions, Integer> {
    TypeSuccessions findByLibelle(String nom);
}
