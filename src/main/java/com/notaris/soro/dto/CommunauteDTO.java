package com.notaris.soro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.clients.Physique;
import com.notaris.soro.models.liquidation.Communaute;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CommunauteDTO {
    private Integer id;

    private String intitule;

    private LocalDate dateOuverture;
    @JsonIgnore
    private Physique physque;

    private String commentaire;

    public static CommunauteDTO toEntityDTO(Communaute communaute){
        if(communaute == null){
            return null;
        }
        return CommunauteDTO.builder()
                .commentaire(communaute.getCommentaire())
                .physque(communaute.getPhysque())
                .dateOuverture(communaute.getDateOuverture())
                .intitule(communaute.getIntitule())
                .id(communaute.getId()).build();

    }

    public static Communaute toEntity(CommunauteDTO dto){
        if(dto == null){
            return null;
        }
        Communaute communaute = new Communaute();
        communaute.setCommentaire(dto.getCommentaire());
        communaute.setDateOuverture(dto.dateOuverture);
        communaute.setIntitule(dto.getIntitule());
        communaute.setPhysque(dto.getPhysque());
        communaute.setId(dto.getId());
        return communaute;
    }
}
