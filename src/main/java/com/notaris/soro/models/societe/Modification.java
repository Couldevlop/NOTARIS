package com.notaris.soro.models.societe;

import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.clients.Physique;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cs_modificationsociete")
public class Modification extends AbstractEntity implements Serializable {
    @Column(name = "objet")
    private String objet;

    @ManyToOne
    private Physique physique;

    @ManyToOne
    private NatureSociete natureSociete;

    @ManyToOne
    private TypeSociete typeSociete;

    @Column(name = "motif")
    private String motif;

    @Column(name = "dateouverture")
    private LocalDate dateOuverture;
}
