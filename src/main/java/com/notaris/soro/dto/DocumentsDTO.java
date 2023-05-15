package com.notaris.soro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.ActeImmobilier;
import com.notaris.soro.models.Documents;
import jakarta.persistence.Lob;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentsDTO {
    private Integer id;

    private String docName;
    private String docType;

    @Lob
    @JsonIgnore
    private byte[] data;
    @JsonIgnore
    private ActeImmobilier acteimmo;

    public static DocumentsDTO toEntityDTO(Documents doc){
        if(doc == null){
            return null;
        }

        return DocumentsDTO.builder()
                .id(doc.getId())
                .docName(doc.getDocName())
                .docType(doc.getDocType())
                .data(doc.getData())
                .acteimmo(doc.getActeimmo())
                .build();
    }


    public static Documents toEntity(Documents dto){
        Documents doc = new Documents();
        doc.setId(dto.getId());
        doc.setDocName(dto.getDocName());
        doc.setDocType(dto.getDocType());
        doc.setData(dto.getData());
        doc.setActeimmo(dto.getActeimmo());
        return doc;
    }
}
