package com.notaris.soro.dto;

import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.clients.Physique;
import com.notaris.soro.models.societe.Creation;
import com.notaris.soro.models.societe.NatureSociete;
import com.notaris.soro.models.societe.TypeSociete;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
public class CreationDTO extends AbstractEntity implements Serializable {
    private Integer id;
    private String intitule;

    private Physique physique;

    private NatureSociete natureSociete;

    private TypeSociete typeSociete;

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
                .physique(creation.getPhysique())
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
        creation.setPhysique(dto.getPhysique());
        creation.setNatureSociete(dto.getNatureSociete());
        creation.setTypeSociete(dto.getTypeSociete());
        creation.setId(dto.getId());
        return creation;
    }
}
