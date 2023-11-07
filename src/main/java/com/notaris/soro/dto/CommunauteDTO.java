package com.notaris.soro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.DocumentsCommunaute;
import com.notaris.soro.models.clients.Physique;
import com.notaris.soro.models.liquidation.Communaute;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CommunauteDTO {
    private Integer id;

    private String intitule;

    private LocalDate dateOuverture;

    private String client;

    private String commentaire;

    //@JsonIgnore
    private List<DocumentsCommunauteDTO> documentsDTOList;

    public static CommunauteDTO toEntityDTO(Communaute communaute){
        if(communaute == null){
            return null;
        }
        return CommunauteDTO.builder()
                .commentaire(communaute.getCommentaire())
                .client(communaute.getClient())
                .dateOuverture(communaute.getDateOuverture())
                .intitule(communaute.getIntitule())
                .documentsDTOList(
                        communaute.getDocuments() != null ? communaute.getDocuments().
                                stream().map(DocumentsCommunauteDTO::toEntityDTO).collect(Collectors.toList()):null
                )
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
        communaute.setClient(dto.getClient());
        communaute.setId(dto.getId());
        return communaute;
    }
}
