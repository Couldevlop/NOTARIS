package com.notaris.soro.models.clients;

import com.notaris.soro.enums.Nature;
import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.Adresse;
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
@Entity
@Builder
@Table(name = "cs_clientmoral")
public class Moral extends AbstractEntity implements Serializable {
    @Column(name = "sigle")
    private String sigle;

    @Column(name = "raisonsociale")
    private String raisonSociale;

    @Column(name = "nature")
    private String nature;

    @Column(name = "email")
    private String email;

    @Column(name = "activite")
    private String activite;

    @Column(name = "numrccm")
    private String numRCCM;

    @Column(name = "dfe")
    private String DFE;

    @Embedded
    private Adresse adresse;

    @Column(name = "logo")
    private String logo;

    @Column(name = "fixe")
    private String fixe;

    @Column(name = "fax")
    private String fax;

    @Column(name = "representantlegal")
    private String representantLegal;

    @Column(name = "numpiecedirigeant")
    private String numPieceDirigeant;

    @Column(name = "localisation")
    private String localisation;
}
