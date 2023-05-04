package com.notaris.soro.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cs_document")
public class Documents extends AbstractEntity implements Serializable {
    private Integer dossierId;
    @OneToOne
    private TypeDocument typeDocument;
}
