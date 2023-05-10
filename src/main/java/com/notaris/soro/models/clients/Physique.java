package com.notaris.soro.models.clients;

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
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cs_clientphysique")
public class Physique extends AbstractEntity implements Serializable {
    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name= "telephonemobile")
    private String mobile;

    @Column(name = "telepnonefixe")
    private String fixe;

    @Column(name = "email")
    private String email;

    @Embedded
    private Adresse adresse;

    @Column(name = "profession")
    private String profession;

    @Column(name = "lieudetravail")
    private String lieuDeTravail;

    @Column(name = "datedenaissance")
    private LocalDate dateNaissance;

    @Column(name = "photo")
    private String photo;

    @Column(name = "situationmatrimoniale")
    private String situationMatrimoniale;

}
