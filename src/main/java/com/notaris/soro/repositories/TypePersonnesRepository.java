package com.notaris.soro.repositories;

import com.notaris.soro.models.admin.TypePersonnes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypePersonnesRepository extends JpaRepository<TypePersonnes, Integer> {
    TypePersonnes findTypePersonnesByNom(String nom);
}
