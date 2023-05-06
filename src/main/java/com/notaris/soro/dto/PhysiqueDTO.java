package com.notaris.soro.dto;

import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.Adresse;
import com.notaris.soro.models.Physique;
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

    public static PhysiqueDTO toEntityDTO(Physique physique){
        if(physique == null){
            return null;
        }

        return PhysiqueDTO.builder()
                .adresse(AdresseDTO.toEntityDTO(physique.getAdresse()))
                .dateNaissance(physique.getDateNaissance())
                .fixe(physique.getFixe())
                .email(physique.getEmail())
                .lieuDeTravail(physique.getLieuDeTravail())
                .mobile(physique.getMobile())
                .adresse(AdresseDTO.toEntityDTO(physique.getAdresse()))
                .nom(physique.getNom())
                .photo(physique.getPhoto())
                .prenom(physique.getPrenom())
                .profession(physique.getProfession())
                .situationMatrimoniale(physique.getSituationMatrimoniale()).build();

    }

    public static Physique toEntity(PhysiqueDTO dto){
        if(dto == null){
            return null;
        }
        Physique physique = new Physique();
        physique.setFixe(dto.getFixe());
        physique.setAdresse(AdresseDTO.toEntity(dto.getAdresse()));
        physique.setDateNaissance(dto.getDateNaissance());
        physique.setEmail(dto.getEmail());
        physique.setLieuDeTravail(dto.getLieuDeTravail());
        physique.setMobile(dto.getMobile());
        physique.setSituationMatrimoniale(dto.getSituationMatrimoniale());
        physique.setEmail(dto.getEmail());
        physique.setMobile(dto.getMobile());
        physique.setPrenom(dto.getPrenom());
        return physique;
    }
}
