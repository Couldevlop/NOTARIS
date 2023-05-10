package com.notaris.soro.repositories;

import com.notaris.soro.models.clients.Banque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BanqueRepository extends JpaRepository<Banque, Integer> {
    Optional<Banque> findBySigle(String sigle);
}
