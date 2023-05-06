package com.notaris.soro.repositories;

import com.notaris.soro.models.Moral;
import com.notaris.soro.models.Physique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MoralRepository extends JpaRepository<Moral, Integer> {
    Optional<Moral> findByEmail(String email);
    Optional<Moral> findByNom(String nom);
}
