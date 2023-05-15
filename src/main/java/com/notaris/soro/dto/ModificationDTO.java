package com.notaris.soro.dto;

import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.clients.Physique;
import com.notaris.soro.models.societe.Modification;
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
public class ModificationDTO extends AbstractEntity implements Serializable {
    private Integer id;

    private String objet;

    private Physique physique;

    private NatureSociete natureSociete;

    private TypeSociete typeSociete;

    private String motif;

    private LocalDate dateOuverture;

    public static ModificationDTO toEntityDTO(Modification modification){
        if(modification == null){
            return null;
        }
        return ModificationDTO.builder()
                .dateOuverture(modification.getDateOuverture())
                .motif(modification.getMotif())
                .natureSociete(modification.getNatureSociete())
                .physique(modification.getPhysique())
                .typeSociete(modification.getTypeSociete())
                .dateOuverture(modification.getDateOuverture())
                .id(modification.getId()).build();
    }

    public static Modification toEntity(ModificationDTO dto){
        if(dto == null){
            return null;
        }

        Modification modification = new Modification();
        modification.setMotif(dto.getMotif());
        modification.setObjet(dto.getObjet());
        modification.setDateOuverture(dto.getDateOuverture());
        modification.setNatureSociete(dto.getNatureSociete());
        modification.setPhysique(dto.getPhysique());
        modification.setTypeSociete(dto.getTypeSociete());
        modification.setId(modification.getId());
        return modification;
    }

}
