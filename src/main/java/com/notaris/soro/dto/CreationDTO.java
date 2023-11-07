package com.notaris.soro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.clients.Physique;
import com.notaris.soro.models.societe.Creation;
import com.notaris.soro.models.admin.NatureSociete;
import com.notaris.soro.models.admin.TypeSociete;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class CreationDTO extends AbstractEntity implements Serializable {
    private Integer id;
    private String intitule;

    private String client;

    private String natureSociete;

    private String typeSociete;

    private String commentaire;

    private LocalDate dateOuverture;

    public static CreationDTO toEntityDTO(Creation creation){
        if(creation == null){
            return null;
        }

        return CreationDTO.builder()
                .commentaire(creation.getCommentaire())
                .dateOuverture(creation.getDateOuverture())
                .intitule(creation.getIntitule())
                .natureSociete(creation.getNatureSociete())
                .client(creation.getClient())
                .typeSociete(creation.getTypeSociete())
                .id(creation.getId()).build();
    }

    public static Creation toEntity(CreationDTO dto){
        if(dto == null){
            return null;
        }

        Creation creation = new Creation();
        creation.setCommentaire(dto.getCommentaire());
        creation.setIntitule(dto.getIntitule());
        creation.setDateOuverture(dto.getDateOuverture());
        creation.setClient(dto.getClient());
        creation.setNatureSociete(dto.getNatureSociete());
        creation.setTypeSociete(dto.getTypeSociete());
        creation.setId(dto.getId());
        return creation;
    }
}
