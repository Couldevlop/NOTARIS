package com.notaris.soro.dto.admin;

import com.notaris.soro.models.admin.TypePieces;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TypePiecesDTO {
    private Integer id;
    private String libelle;



    public static TypePiecesDTO toEntityDTO(TypePieces typePieces){
        if(typePieces == null){
            return  null;
        }
        return TypePiecesDTO.builder()
                .id(typePieces.getId())
                .libelle(typePieces.getLibelle())
                .build();
    }


    public static TypePieces toEntity(TypePiecesDTO dto){
        if(dto ==  null){
            return null;
        }

        TypePieces pieces = new TypePieces();
        pieces.setId(dto.getId());
        pieces.setLibelle(dto.getLibelle());
        return pieces;
    }
}

