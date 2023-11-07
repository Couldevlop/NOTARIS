package com.notaris.soro.dto.admin;

import com.notaris.soro.models.admin.TypePersonnes;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TypePersonnesDTO {
    private Integer id;
    private String nom;



    public static TypePersonnesDTO toEntityDTO(TypePersonnes typePersonnes){
        if(typePersonnes == null){
            return  null;
        }
        return TypePersonnesDTO.builder()
                .id(typePersonnes.getId())
                .nom(typePersonnes.getNom())
                .build();
    }


    public static TypePersonnes toEntity(TypePersonnesDTO dto){
        if(dto ==  null){
            return null;
        }
          TypePersonnes personnes =  new TypePersonnes();
          personnes.setNom(dto.getNom());
          personnes.setId(dto.getId());
        return personnes;

    }
}

