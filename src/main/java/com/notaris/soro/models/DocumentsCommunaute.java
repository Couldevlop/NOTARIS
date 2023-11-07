package com.notaris.soro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.liquidation.Communaute;
import com.notaris.soro.models.societe.Creation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cs_documentcommunaute")
public class DocumentsCommunaute implements Serializable {
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
    private Communaute doccommunuate;


 public DocumentsCommunaute(String docName, String docType, byte[] data) {
  this.docName = docName;
  this.docType = docType;
  this.data = data;
 }

 public DocumentsCommunaute(String docName, String docType, byte[] data, Communaute doccommunuate) {
  this.docName = docName;
  this.docType = docType;
  this.data = data;
  this.doccommunuate = doccommunuate;
 }

 public DocumentsCommunaute(Integer id, String typeDoc, String intitule, String docName, String docType, byte[] data, Communaute doccommunuate) {
  this.id = id;
  this.typeDoc = typeDoc;
  this.intitule = intitule;
  this.docName = docName;
  this.docType = docType;
  this.data = data;
  this.doccommunuate = doccommunuate;
 }

 public DocumentsCommunaute(String typeDoc, String intitule, String docName, String docType, byte[] data, Communaute doccommunuate) {
  this.typeDoc = typeDoc;
  this.intitule = intitule;
  this.docName = docName;
  this.docType = docType;
  this.data = data;
  this.doccommunuate = doccommunuate;
 }
}
