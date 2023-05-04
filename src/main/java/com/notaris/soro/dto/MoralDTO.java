package com.notaris.soro.dto;

import com.notaris.soro.enums.Nature;
import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.Moral;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data

@Builder

public class MoralDTO  {
    private String sigle;

    private AdresseDTO adresse;

    private String raisonSociale;

    private Nature nature;

    private String activite;

    private String numRCCM;

    private String DFE;

    private String logo;

    private String fixe;

    private String fax;

    private String representantLegal;

    private String numPieceDirigeant;

    private String localisation;

    public static MoralDTO toEntityDTO(Moral moral){
        if(moral == null){
            return null;
        }
        return MoralDTO.builder()
                .activite(moral.getActivite())
                .DFE(moral.getDFE())
                .fax(moral.getFax())
                .fixe(moral.getFixe())
                .localisation(moral.getLocalisation())
                .nature(moral.getNature())
                .numRCCM(moral.getNumRCCM())
                .logo(moral.getLogo())
                .numPieceDirigeant(moral.getNumPieceDirigeant())
                .numPieceDirigeant(moral.getNumPieceDirigeant())
                .sigle(moral.getSigle()).build();
    }


    public static Moral toEntity(MoralDTO dto){
        Moral moral = new Moral();
        moral.setActivite(dto.getActivite());
        moral.setDFE(dto.getDFE());
        moral.setFax(dto.getFax());
        moral.setLocalisation(dto.getLocalisation());
        moral.setNumRCCM(dto.getNumRCCM());
        moral.setNature(dto.getNature());
        moral.setAdresse(AdresseDTO.toEntity(dto.getAdresse()));
        moral.setLogo(dto.getLogo());
        moral.setRepresentantLegal(dto.getRepresentantLegal());
        moral.setNumPieceDirigeant(dto.getNumPieceDirigeant());
        return moral;
    }
}
