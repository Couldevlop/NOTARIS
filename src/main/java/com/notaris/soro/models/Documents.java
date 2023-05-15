package com.notaris.soro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.societe.Creation;
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
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
   @GenericGenerator(name = "native", strategy = "native")

    private Integer id;

    private String docName;
    private String docType;

    @Lob
    private byte[] data;

    @ManyToOne
    @JsonIgnore
    private ActeImmobilier acteimmo;

    @ManyToOne
    @JsonIgnore
    private Creation creation;




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
