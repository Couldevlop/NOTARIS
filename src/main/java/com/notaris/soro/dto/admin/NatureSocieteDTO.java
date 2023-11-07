package com.notaris.soro.dto.admin;



import com.notaris.soro.models.admin.NatureSociete;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NatureSocieteDTO {
    private Integer id;

    private String libelle;

    private String description;

    public static NatureSocieteDTO toEntityDTO(NatureSociete natureSociete){
        if(natureSociete == null){
            return null;
        }
        return NatureSocieteDTO.builder()
                .description(natureSociete.getDescription())
                .libelle(natureSociete.getLibelle())
                .id(natureSociete.getId()).build();
    }

    public static NatureSociete toEntity(NatureSocieteDTO dto){
        if(dto == null){
            return null;
        }

        NatureSociete natureSociete = new NatureSociete();
        natureSociete.setLibelle(dto.getLibelle());
        natureSociete.setDescription(dto.getDescription());
        natureSociete.setId(dto.getId());
        return natureSociete;
    }


}
