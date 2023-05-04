package com.notaris.soro.dto;

import com.notaris.soro.models.TypeDocument;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentsDTO {
    private Integer id;

    private Integer dossierId;

    private TypeDocument typeDocument;
}
