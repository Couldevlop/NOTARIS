package com.notaris.soro.dto.admin;

import com.notaris.soro.models.admin.Pays;
import com.notaris.soro.models.admin.Ville;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VilleDTO {
    private Integer id;
    private String nom;


    public static VilleDTO toEntityDTO(Ville ville){
        if(ville == null){
            return  null;
        }
        return VilleDTO.builder()
                .id(ville.getId())
                .nom(ville.getNom())
                .build();
    }


    public static Ville toEntity(VilleDTO dto){
        if(dto ==  null){
            return null;
        }

        Ville ville = new Ville();
        ville.setId(dto.id);
        ville.setNom(dto.getNom());
        return ville;
    }
}

