package com.notaris.soro.dto;

import com.notaris.soro.models.clients.Physique;
import com.notaris.soro.models.liquidation.Sessions;
import com.notaris.soro.models.liquidation.TypeSession;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;


@Data
@Builder
public class SessionsDTO {
    private Integer id;

    private TypeSession typeSession;

    private String intitule;

    private LocalDate dateOuverture;

    private String commentaire;

    public static SessionsDTO toEntityDTO(Sessions session){
        if(session == null){
            return null;
        }
        return SessionsDTO.builder()
                .commentaire(session.getCommentaire())
                .dateOuverture(session.getDateOuverture())
                .id(session.getId())
                .intitule(session.getIntitule())
                .intitule(session.getIntitule())
                .typeSession(session.getTypeSession()).build();

    }


    public static Sessions toEntity(SessionsDTO dto){
        if(dto == null){
            return null;
        }

        Sessions sessions = new Sessions();
        sessions.setTypeSession(dto.typeSession);
        sessions.setCommentaire(dto.getCommentaire());
        sessions.setDateOuverture(dto.getDateOuverture());
        sessions.setIntitule(dto.getIntitule());
        sessions.setId(dto.getId());
        return sessions;
    }
}
