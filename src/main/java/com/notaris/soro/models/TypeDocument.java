package com.notaris.soro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cs_typedocument")
public class TypeDocument extends AbstractEntity{
    private String libelle;
    private String description;
}
