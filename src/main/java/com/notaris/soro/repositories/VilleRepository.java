package com.notaris.soro.repositories;

import com.notaris.soro.models.admin.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VilleRepository extends JpaRepository<Ville, Integer> {
    Ville findByNom(String nom);
}
