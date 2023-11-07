package com.notaris.soro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.DocumentsSuccession;
import com.notaris.soro.models.liquidation.Succession;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class DocumentsSuccesionDTO {
    private Integer id;
    private String intitule;
    private String docName;
    private String docType;
    public String typeDoc;
    //@JsonIgnore
    private byte[] data;
    @JsonIgnore
    private Succession succession;

    public static DocumentsSuccesionDTO toEntityDTO(DocumentsSuccession doc){
        if(doc == null){
            return null;
        }

        return DocumentsSuccesionDTO.builder()
                .id(doc.getId())
                .docName(doc.getDocName())
                .docType(doc.getDocType())
                .data(doc.getData())
                .intitule(doc.getIntitule())
                .succession(doc.getDocsuccession())
                .typeDoc(doc.getTypeDoc())
                .build();
    }


    public static DocumentsSuccession toEntity(DocumentsSuccesionDTO dto){
        DocumentsSuccession doc = new DocumentsSuccession();
        doc.setId(dto.getId());
        doc.setDocName(dto.getDocName());
        doc.setDocType(dto.getDocType());
         doc.setData(dto.getData());
        doc.setIntitule(dto.getIntitule());
        doc.setDocsuccession(dto.getSuccession());
        doc.setDocType(dto.getTypeDoc());
        return doc;
    }


    public static List<DocumentsSuccesionDTO> toListEntityDTO(List<DocumentsSuccession> documentsList){
        List<DocumentsSuccesionDTO> dtoList = new ArrayList<>();
        for (DocumentsSuccession doc: documentsList) {
            dtoList.add(toEntityDTO(doc));
        }
        return dtoList;
    }
}
