package com.notaris.soro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cs_ouverturecredit")
public class OuvertureCredit extends  AbstractEntity implements Serializable {
    @Column(name = "intitule")
    private String intitule;

    @Column(name="montant")
    private double montant;

    @Column(name = "client")
    private String client;

    @Column(name = "commentatire")
    private String commentaire;


    @Column(name = "taux")
    private double taux;

    @Column(name = "dateOuverture")
    private LocalDate dateOuverture;

    @Column(name = "gestionnaire")
    private String gestionnaire;
}
