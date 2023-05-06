package com.notaris.soro.models;

import com.notaris.soro.enums.Nature;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
@Table(name = "cs_clientbanque")
public class Banque extends AbstractEntity implements Serializable {
    @Column(name = "sigle")
    private String sigle;

    @Column(name = "raisonsociale")
    private String raisonSociale;

    @Embedded
    private Adresse adresse;

    @Column(name = "nature")
    private Nature nature;

    @Column(name = "activite")
    private String activite;

    @Column(name = "numrccm")
    private String numRCCM;

    @Column(name = "dfe")
    private String DFE;

    @Column(name = "logo")
    private String logo;

    @Column(name = "fixe")
    private String fixe;

    @Column(name = "fax")
    private String fax;

    @Column(name = "nomdirigeant")
    private String nomDirigeant;
}
