package com.notaris.soro.dto.admin;

import com.notaris.soro.models.admin.Pays;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaysDTO {
    private Integer id;
    private String nom;



    public static PaysDTO toEntityDTO(Pays pays){
        if(pays == null){
            return null;
        }
        return  PaysDTO.builder()
                .id(pays.getId())
                .nom(pays.getNom())
                .build();
    }


    public static Pays toEntity(PaysDTO dto){
        if(dto == null){
            return null;
        }
        Pays pays = new Pays();
        pays.setId(dto.getId());
        pays.setNom(dto.getNom());
        return pays;
    }

}
