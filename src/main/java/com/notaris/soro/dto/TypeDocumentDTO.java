package com.notaris.soro.dto;

import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.TypeDocument;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class TypeDocumentDTO {
    private Integer id;
    private String libelle;
    private String description;

    public static TypeDocumentDTO toEntityDTO(TypeDocument typeDocument){
        if(typeDocument == null){
            return null;
        }

        return TypeDocumentDTO.builder()
                .id(typeDocument.getId())
                .description(typeDocument.getDescription())
                .libelle(typeDocument.getLibelle())
                .build();
    }

    public static TypeDocument toEntity(TypeDocumentDTO dto){
        if(dto == null){
            return null;
        }
        TypeDocument typeDocument = new TypeDocument();
        typeDocument.setDescription(dto.getDescription());
        typeDocument.setLibelle(dto.getLibelle());
        typeDocument.setId(dto.getId());
        return typeDocument;
    }
}
