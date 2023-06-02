package com.notaris.soro.dto;

import com.notaris.soro.models.clients.Physique;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PhysiqueDTO  {
    private Integer id;

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
                .id(physique.getId())
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
        physique.setFixe(dto.getFixe());
        physique.setMobile(dto.getMobile());
        physique.setPrenom(dto.getPrenom());
        physique.setId(dto.getId());
        physique.setProfession(dto.getProfession());
        physique.setNom(dto.getNom());
        return physique;
    }
}
