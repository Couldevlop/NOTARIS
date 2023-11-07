package com.notaris.soro.dto.admin;

import com.notaris.soro.models.admin.Pays;
import com.notaris.soro.models.admin.TypeSuccessions;
import com.notaris.soro.models.admin.Ville;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TypeSuccessionsDTO {
    private Integer id;
    private String libelle;


    public static TypeSuccessionsDTO toEntityDTO(TypeSuccessions typeSuccessions){
        if(typeSuccessions == null){
            return  null;
        }
        return TypeSuccessionsDTO.builder()
                .libelle(typeSuccessions.getLibelle())
                .id(typeSuccessions.getId())
                .build();
    }


    public static TypeSuccessions toEntity(TypeSuccessionsDTO dto){
        if(dto ==  null){
            return null;
        }

        TypeSuccessions successions = new TypeSuccessions();
        successions.setId(dto.getId());
        successions.setLibelle(dto.getLibelle());
       return successions;
    }
}

