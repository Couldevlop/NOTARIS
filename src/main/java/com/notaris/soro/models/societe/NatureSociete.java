package com.notaris.soro.models.societe;

import com.notaris.soro.models.AbstractEntity;
import jakarta.persistence.Column;
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
@Table(name = "cs_naturesociete")
public class NatureSociete  extends AbstractEntity implements Serializable {
    @Column(name = "libelle")
    private String libelle;

    @Column(name = "description")
    private String description;
}
