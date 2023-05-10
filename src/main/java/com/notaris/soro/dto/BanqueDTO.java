package com.notaris.soro.dto;

import com.notaris.soro.enums.Nature;
import com.notaris.soro.models.clients.Banque;
import lombok.Builder;
import lombok.Data;



@Builder
@Data
public class BanqueDTO {
    private Integer id;

    private String sigle;

    private String raisonSociale;

    private AdresseDTO adresse;

    private Nature nature;

    private String activite;

    private String numRCCM;

    private String DFE;

    private String logo;

    private String fixe;

    private String fax;

    private String nomDirigeant;


    public static BanqueDTO toEntityDTO(Banque banque){
        if(banque == null){
            return null;
        }
        return BanqueDTO.builder()
                .id(banque.getId())
                .fax(banque.getFax())
                .logo(banque.getLogo())
                .activite(banque.getActivite())
                .numRCCM(banque.getNumRCCM())
                .DFE(banque.getDFE())
                .nature(banque.getNature())
                .nomDirigeant(banque.getNomDirigeant())
                .sigle(banque.getSigle())
                .adresse(AdresseDTO.toEntityDTO(banque.getAdresse()))
                .raisonSociale(banque.getRaisonSociale()).build();
    }



    public static Banque toEntity(BanqueDTO dto){
        if(dto == null){
            return null;
        }

        Banque b = new Banque();
        b.setActivite(dto.getActivite());
        b.setDFE(dto.getDFE());
        b.setFax(dto.getFax());
        b.setLogo(dto.getLogo());
        b.setNature(dto.nature);
        b.setNumRCCM(dto.getNumRCCM());
        b.setRaisonSociale(dto.getRaisonSociale());
        b.setFixe(dto.getFixe());
        b.setSigle(dto.getSigle());
        b.setAdresse(AdresseDTO.toEntity(dto.getAdresse()));
        b.setNomDirigeant(dto.getNomDirigeant());
        return b;
    }
}
