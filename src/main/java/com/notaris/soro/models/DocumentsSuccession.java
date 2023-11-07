package com.notaris.soro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.liquidation.Succession;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cs_documentsuccession")
public class DocumentsSuccession implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
   @GenericGenerator(name = "native", strategy = "native")

    private Integer id;

   public String typeDoc;

   private String intitule;
    private String docName;
    private String docType;

    @Lob
    private byte[] data;

    @ManyToOne
    @JsonIgnore
    private Succession docsuccession;





 public DocumentsSuccession(String docName, String docType, byte[] data) {
  this.docName = docName;
  this.docType = docType;
  this.data = data;
 }

 public DocumentsSuccession(String docName, String docType, byte[] data, Succession docsuccession) {
  this.docName = docName;
  this.docType = docType;
  this.data = data;
  this.docsuccession = docsuccession;
 }

 public DocumentsSuccession(Integer id, String typeDoc, String intitule, String docName, String docType, byte[] data, Succession docsuccession) {
  this.id = id;
  this.typeDoc = typeDoc;
  this.intitule = intitule;
  this.docName = docName;
  this.docType = docType;
  this.data = data;
  this.docsuccession = docsuccession;
 }


 public DocumentsSuccession(String typeDoc, String intitule, String docName, String docType, byte[] data, Succession docsuccession) {
  this.typeDoc = typeDoc;
  this.intitule = intitule;
  this.docName = docName;
  this.docType = docType;
  this.data = data;
  this.docsuccession = docsuccession;
 }
}
