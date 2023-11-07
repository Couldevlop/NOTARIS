package com.notaris.soro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.liquidation.Succession;
import lombok.Builder;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
public class SuccessionDTO {
    private Integer id;

    private String typeSuccession;

    private String intitule;

    private String client;

    private LocalDate dateOuverture;

    private String commentaire;

    //@JsonIgnore
    private List<DocumentsSuccesionDTO> documentsDTOList;

    public static SuccessionDTO toEntityDTO(Succession succession){
        if(succession == null){
            return null;
        }
        return SuccessionDTO.builder()
                .commentaire(succession.getCommentaire())
                .dateOuverture(succession.getDateOuverture())
                .id(succession.getId())
                .intitule(succession.getIntitule())
                .intitule(succession.getIntitule())
                .client(succession.getClient())
                .documentsDTOList(succession.getDocuments() != null ? succession.getDocuments().stream().
                        map(DocumentsSuccesionDTO::toEntityDTO).collect(Collectors.toList()) : null)
                .typeSuccession(succession.getTypeSuccession()).build();

    }


    public static Succession toEntity(SuccessionDTO dto){
        if(dto == null){
            return null;
        }

        Succession succession = new Succession();
        succession.setTypeSuccession(dto.typeSuccession);
        succession.setCommentaire(dto.getCommentaire());
        succession.setDateOuverture(dto.getDateOuverture());
        succession.setIntitule(dto.getIntitule());
        succession.setClient(dto.client);
        succession.setId(dto.getId());
        return succession;
    }
}
