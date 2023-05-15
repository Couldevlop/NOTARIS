package com.notaris.soro.dto;

import com.notaris.soro.models.liquidation.Sucession;
import com.notaris.soro.models.liquidation.TypeSession;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;


@Data
@Builder
public class SucessionDTO {
    private Integer id;

    private TypeSession typeSession;

    private String intitule;

    private LocalDate dateOuverture;

    private String commentaire;

    public static SucessionDTO toEntityDTO(Sucession session){
        if(session == null){
            return null;
        }
        return SucessionDTO.builder()
                .commentaire(session.getCommentaire())
                .dateOuverture(session.getDateOuverture())
                .id(session.getId())
                .intitule(session.getIntitule())
                .intitule(session.getIntitule())
                .typeSession(session.getTypeSession()).build();

    }


    public static Sucession toEntity(SucessionDTO dto){
        if(dto == null){
            return null;
        }

        Sucession sucession = new Sucession();
        sucession.setTypeSession(dto.typeSession);
        sucession.setCommentaire(dto.getCommentaire());
        sucession.setDateOuverture(dto.getDateOuverture());
        sucession.setIntitule(dto.getIntitule());
        sucession.setId(dto.getId());
        return sucession;
    }
}
