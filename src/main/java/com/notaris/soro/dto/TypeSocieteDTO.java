package com.notaris.soro.dto;

import com.notaris.soro.models.admin.TypeSociete;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TypeSocieteDTO  {
    private Integer id;
    private String libelle;
    private String description;

    public static TypeSocieteDTO toEntityDTO(TypeSociete typeSociete){
        if(typeSociete == null){
            return null;
        }

        return TypeSocieteDTO.builder()
                .id(typeSociete.getId())
                .description(typeSociete.getDescription())
                .libelle(typeSociete.getLibelle()).build();
    }

    public static TypeSociete toEntity(TypeSocieteDTO dto){
        if(dto == null){
            return  null;
        }
        TypeSociete typeSociete = new TypeSociete();
        typeSociete.setId(dto.getId());
        typeSociete.setDescription(dto.getDescription());
        typeSociete.setLibelle(dto.getLibelle());
        return typeSociete;
    }
}
