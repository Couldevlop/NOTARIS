package com.notaris.soro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.clients.Physique;
import com.notaris.soro.models.societe.Modification;
import com.notaris.soro.models.admin.NatureSociete;
import com.notaris.soro.models.admin.TypeSociete;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ModificationDTO extends AbstractEntity implements Serializable {
    private Integer id;

    private String objet;

    private String client;

    private String natureSociete;

    private String typeSociete;

    private String motif;

    private LocalDate dateOuverture;
    @JsonIgnore
    private List<DocumentsModifSocieteDTO> documentsDTOList;

    public static ModificationDTO toEntityDTO(Modification modification){
        if(modification == null){
            return null;
        }
        return ModificationDTO.builder()
                .dateOuverture(modification.getDateOuverture())
                .motif(modification.getMotif())
                .natureSociete(modification.getNatureSociete())
                .client(modification.getClient())
                .typeSociete(modification.getTypeSociete())
                .dateOuverture(modification.getDateOuverture())
                .objet(modification.getObjet())
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
        modification.setClient(dto.getClient());
        modification.setTypeSociete(dto.getTypeSociete());
        modification.setId(modification.getId());
        return modification;
    }

}
