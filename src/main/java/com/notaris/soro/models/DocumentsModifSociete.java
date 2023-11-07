package com.notaris.soro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.societe.Creation;
import com.notaris.soro.models.societe.Modification;
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
@Table(name = "cs_documentmodifsociete")
public class DocumentsModifSociete implements Serializable {
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
    private Modification modifscte;

    @ManyToOne
    @JsonIgnore
    private Creation creation;




 public DocumentsModifSociete(String docName, String docType, byte[] data) {
  this.docName = docName;
  this.docType = docType;
  this.data = data;
 }

 public DocumentsModifSociete(String docName, String docType, byte[] data, Modification modif) {
  this.docName = docName;
  this.docType = docType;
  this.data = data;
  this.modifscte = modif;
 }

 public DocumentsModifSociete(Integer id, String typeDoc, String intitule, String docName, String docType, byte[] data, Modification modification) {
  this.id = id;
  this.typeDoc = typeDoc;
  this.intitule = intitule;
  this.docName = docName;
  this.docType = docType;
  this.data = data;
  this.modifscte = modification;
 }
}
