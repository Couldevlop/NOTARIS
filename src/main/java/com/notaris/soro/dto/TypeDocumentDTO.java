package com.notaris.soro.dto;

import com.notaris.soro.models.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class TypeDocumentDTO {
    private String libelle;
    private String description;
}
