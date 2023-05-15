package com.notaris.soro.models.societe;

import com.notaris.soro.models.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cs_typesociete")
public class TypeSociete extends AbstractEntity implements Serializable {
    private String libelle;
    private String description;
}
