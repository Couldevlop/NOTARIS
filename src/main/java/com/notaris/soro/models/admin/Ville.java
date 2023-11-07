package com.notaris.soro.models.admin;

import com.notaris.soro.models.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "cs_ville")
public class Ville extends AbstractEntity {
    private String nom;
}
