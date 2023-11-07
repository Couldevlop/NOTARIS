package com.notaris.soro.repositories;

import com.notaris.soro.models.societe.Modification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModificationRepository extends JpaRepository<Modification, Integer> {
    Modification findByObjet(String objet);
}
