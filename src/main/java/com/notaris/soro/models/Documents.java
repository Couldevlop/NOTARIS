package com.notaris.soro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cs_document")
public class Documents implements Serializable {
   /* @Column(name = "dossierid")
    private Integer dossierId;

    @ManyToOne
    private TypeDocument typeDocument;*/
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private String docName;
    private String docType;

    @Lob
    private byte[] data;

    @ManyToOne
    @JsonIgnore
    private ActeImmobilier acteimmo;




 public Documents(String docName, String docType, byte[] data) {
  this.docName = docName;
  this.docType = docType;
  this.data = data;
 }

 public Documents(String docName, String docType, byte[] data, ActeImmobilier immo) {
  this.docName = docName;
  this.docType = docType;
  this.data = data;
  this.acteimmo = immo;
 }
}
