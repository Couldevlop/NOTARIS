package com.notaris.soro.repositories;

import com.notaris.soro.enums.ERole;
import com.notaris.soro.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
