package com.notaris.soro.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.ActeImmobilier;
import com.notaris.soro.models.Documents;
import com.notaris.soro.models.DocumentsCommunaute;
import com.notaris.soro.models.liquidation.Communaute;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class DocumentsCommunauteDTO {
    private Integer id;
    private String intitule;
    private String docName;
    private String docType;
    public String typeDoc;
    //@JsonIgnore
    private byte[] data;
    @JsonIgnore
    private Communaute communaute;

    public static DocumentsCommunauteDTO toEntityDTO(DocumentsCommunaute doc){
        if(doc == null){
            return null;
        }

        return DocumentsCommunauteDTO.builder()
                .id(doc.getId())
                .docName(doc.getDocName())
                .docType(doc.getDocType())
                .data(doc.getData())
                .intitule(doc.getIntitule())
                .communaute(doc.getDoccommunuate())
                .typeDoc(doc.getTypeDoc())
                .build();
    }


    public static DocumentsCommunaute toEntity(DocumentsCommunauteDTO dto){
        DocumentsCommunaute doc = new DocumentsCommunaute();
        doc.setId(dto.getId());
        doc.setDocName(dto.getDocName());
        doc.setDocType(dto.getDocType());
        doc.setData(dto.getData());
        doc.setIntitule(dto.getIntitule());
        doc.setDoccommunuate(dto.getCommunaute());
        doc.setDocType(dto.getTypeDoc());
        return doc;
    }


    public static List<DocumentsCommunauteDTO> toListEntityDTO(List<DocumentsCommunaute> documentsList){
        List<DocumentsCommunauteDTO> dtoList = new ArrayList<>();
        for (DocumentsCommunaute doc: documentsList) {
            dtoList.add(toEntityDTO(doc));
        }
        return dtoList;
    }
}
