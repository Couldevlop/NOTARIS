package com.notaris.soro.models.liquidation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.clients.Physique;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cs_liquidationcommunaute")
public class Communaute extends AbstractEntity implements Serializable {

    @Column(name = "intitule")
    private String intitule;

    @Column(name = "dateouverture")
    private LocalDate dateOuverture;

    @ManyToOne
    @JsonIgnore
    private Physique physque;

    @Column(name = "commentaire")
    private String commentaire;


}
