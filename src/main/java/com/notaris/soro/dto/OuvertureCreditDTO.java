package com.notaris.soro.dto;

import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.Adresse;
import com.notaris.soro.models.OuvertureCredit;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class OuvertureCreditDTO extends AbstractEntity implements Serializable {
    private Integer id;

    private String intitule;

    private double montant;

    private String client;

    private String commentaire;

    private double taux;

    private LocalDate dateOuverture;

    private String gestionnaire;


    public static OuvertureCreditDTO toEntityDTO(OuvertureCredit credit){
        if(credit == null){
            return null;
        }
        return OuvertureCreditDTO.builder()
                .dateOuverture(credit.getDateOuverture())
                .client(credit.getClient())
                .intitule(credit.getIntitule())
                .gestionnaire(credit.getGestionnaire())
                .taux(credit.getTaux())
                .commentaire(credit.getCommentaire())
                .montant(credit.getMontant())
                .id(credit.getId())
                .build();

    }

    public static OuvertureCredit toEnity(OuvertureCreditDTO dto){
        if(dto == null){
            return  null;
        }
        OuvertureCredit ouvertureCredit =  new OuvertureCredit();
        ouvertureCredit.setDateOuverture(dto.getDateOuverture());
        ouvertureCredit.setClient(dto.getClient());
        ouvertureCredit.setIntitule(dto.getIntitule());
        ouvertureCredit.setGestionnaire(dto.gestionnaire);
        ouvertureCredit.setMontant(dto.getMontant());
        ouvertureCredit.setTaux(dto.getTaux());
        ouvertureCredit.setId(dto.getId());
        ouvertureCredit.setCommentaire(dto.getCommentaire());
        return ouvertureCredit;
    }
}
