package com.notaris.soro.models;

import jakarta.persistence.*;
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
    @Column(name = "dossierid")
    private Integer dossierId;

    @ManyToOne
    private TypeDocument typeDocument;

    @Column(name = "nomdocument")
    private String docName;

    @Column(name = "typedocument")
    private String docType;


}
