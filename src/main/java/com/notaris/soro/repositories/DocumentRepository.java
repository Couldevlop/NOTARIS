package com.notaris.soro.repositories;

import com.notaris.soro.models.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Documents, Integer> {

}
