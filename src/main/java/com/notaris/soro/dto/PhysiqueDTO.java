package com.notaris.soro.dto;

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
@Builder
public class PhysiqueDTO  {
    private String nom;

    private String prenom;

    private String mobile;

    private String fixe;

    private String email;

    private AdresseDTO adresse;

    private String profession;

    private String lieuDeTravail;

    private LocalDate dateNaissance;

    private String photo;

    private String situationMatrimoniale;

}
