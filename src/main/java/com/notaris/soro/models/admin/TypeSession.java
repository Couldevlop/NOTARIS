package com.notaris.soro.models.admin;

import com.notaris.soro.models.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cs_typesession")
public class TypeSession extends AbstractEntity implements Serializable {
    @Column(name = "libelle")
    private String libelle;

    @Column(name = "description")
    private String description;
}
