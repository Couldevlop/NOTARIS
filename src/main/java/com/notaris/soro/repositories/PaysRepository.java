package com.notaris.soro.repositories;

import com.notaris.soro.models.admin.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaysRepository extends JpaRepository<Pays, Integer> {
    Pays findByNom(String nom);
}
