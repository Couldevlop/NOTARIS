package com.notaris.soro.repositories;

import com.notaris.soro.models.liquidation.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionsRepository extends JpaRepository<Sessions, Integer> {
    Optional<Sessions> findByIntitule(String intitule);
}
