package com.notaris.soro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.ActeImmobilier;
import com.notaris.soro.models.Documents;
import jakarta.persistence.Lob;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class DocumentsDTO {
    private Integer id;
    private String intitule;
    private String docName;
    private String docType;
    public String typeDoc;
    //@JsonIgnore
    //private byte[] data;
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
                //.data(doc.getData())
                .intitule(doc.getIntitule())
                .acteimmo(doc.getActeimmo())
                .typeDoc(doc.getTypeDoc())
                .build();
    }


    public static Documents toEntity(Documents dto){
        Documents doc = new Documents();
        doc.setId(dto.getId());
        doc.setDocName(dto.getDocName());
        doc.setDocType(dto.getDocType());
      //  doc.setData(dto.getData());
        doc.setIntitule(dto.getIntitule());
        doc.setActeimmo(dto.getActeimmo());
        doc.setDocType(dto.getTypeDoc());
        return doc;
    }


    public static List<DocumentsDTO> toListEntityDTO(List<Documents> documentsList){
        List<DocumentsDTO> dtoList = new ArrayList<>();
        for (Documents doc: documentsList) {
            dtoList.add(toEntityDTO(doc));
        }
        return dtoList;
    }
}
