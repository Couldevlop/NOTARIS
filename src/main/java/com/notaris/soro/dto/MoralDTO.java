package com.notaris.soro.dto;

import com.notaris.soro.enums.Nature;
import com.notaris.soro.models.clients.Moral;
import lombok.Builder;
import lombok.Data;

@Data

@Builder

public class MoralDTO  {
    private Integer id;

    private String sigle;

    private AdresseDTO adresse;

    private String raisonSociale;

    private String nature;

    private String email;

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
                .id(moral.getId())
                .DFE(moral.getDFE())
                .fax(moral.getFax())
                .fixe(moral.getFixe())
                .localisation(moral.getLocalisation())
                .nature(moral.getNature())
                .numRCCM(moral.getNumRCCM())
                .logo(moral.getLogo())
                .email(moral.getEmail())
                .adresse(AdresseDTO.toEntityDTO(moral.getAdresse()))
                .numPieceDirigeant(moral.getNumPieceDirigeant())
                .raisonSociale(moral.getRaisonSociale())
                .sigle(moral.getSigle())
                .representantLegal(moral.getRepresentantLegal()).build();
    }


    public static Moral toEntity(MoralDTO dto){
        Moral moral = new Moral();
        moral.setActivite(dto.getActivite());
        moral.setId(dto.getId());
        moral.setDFE(dto.getDFE());
        moral.setFax(dto.getFax());
        moral.setLocalisation(dto.getLocalisation());
        moral.setNumRCCM(dto.getNumRCCM());
        moral.setNature(dto.getNature());
        moral.setEmail(dto.getEmail());
        moral.setAdresse(AdresseDTO.toEntity(dto.getAdresse()));
        moral.setLogo(dto.getLogo());
        moral.setRepresentantLegal(dto.getRepresentantLegal());
        moral.setNumPieceDirigeant(dto.getNumPieceDirigeant());
        moral.setSigle(dto.getSigle());
        moral.setRaisonSociale(dto.getRaisonSociale());
        return moral;
    }
}
