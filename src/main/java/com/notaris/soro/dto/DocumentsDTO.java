package com.notaris.soro.dto;

import com.notaris.soro.models.Documents;
import com.notaris.soro.models.TypeDocument;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentsDTO {
    private Integer id;

    private Integer dossierId;

    private TypeDocument typeDocument;

    private String docName;

    private String docType;

    public static DocumentsDTO toEntityDTO(DocumentsDTO doc){
        if(doc == null){
            return null;
        }

        return DocumentsDTO.builder()
                .id(doc.getId())
                .docName(doc.getDocName())
                .docType(doc.getDocType())
                .dossierId(doc.getDossierId())
                .typeDocument(doc.getTypeDocument()).build();
    }


    public static Documents toEntity(Documents dto){
        Documents doc = new Documents();
        doc.setId(dto.getId());
        doc.setDocName(dto.getDocName());
        doc.setDocType(dto.getDocType());
        doc.setDossierId(dto.getDossierId());
        doc.setTypeDocument(dto.getTypeDocument());
        return doc;
    }
}
