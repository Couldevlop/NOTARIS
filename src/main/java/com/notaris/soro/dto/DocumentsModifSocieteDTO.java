package com.notaris.soro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.ActeImmobilier;
import com.notaris.soro.models.Documents;
import com.notaris.soro.models.DocumentsModifSociete;
import com.notaris.soro.models.societe.Modification;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class DocumentsModifSocieteDTO {
    private Integer id;
    private String intitule;
    private String docName;
    private String docType;
    public String typeDoc;
    //@JsonIgnore
    //private byte[] data;
    @JsonIgnore
    private Modification modification;

    public static DocumentsModifSocieteDTO toEntityDTO(DocumentsModifSociete doc){
        if(doc == null){
            return null;
        }

        return DocumentsModifSocieteDTO.builder()
                .id(doc.getId())
                .docName(doc.getDocName())
                .docType(doc.getDocType())
                //.data(doc.getData())
                .intitule(doc.getIntitule())
                .modification(doc.getModifscte())
                .typeDoc(doc.getTypeDoc())
                .build();
    }


    public static DocumentsModifSociete toEntity(DocumentsModifSocieteDTO dto){
        DocumentsModifSociete doc = new DocumentsModifSociete();
        doc.setId(dto.getId());
        doc.setDocName(dto.getDocName());
        doc.setDocType(dto.getDocType());
      //  doc.setData(dto.getData());
        doc.setIntitule(dto.getIntitule());
        doc.setModifscte(dto.getModification());
        doc.setDocType(dto.getTypeDoc());
        return doc;
    }


    public static List<DocumentsModifSocieteDTO> toListEntityDTO(List<DocumentsModifSociete> documentsList){
        List<DocumentsModifSocieteDTO> dtoList = new ArrayList<>();
        for (DocumentsModifSociete doc: documentsList) {
            dtoList.add(toEntityDTO(doc));
        }
        return dtoList;
    }
}
