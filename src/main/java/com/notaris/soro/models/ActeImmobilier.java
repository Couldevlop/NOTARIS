package com.notaris.soro.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.enums.TypeActeImmo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cs_acteimmobilier")
public class ActeImmobilier extends AbstractEntity{
 @Column(name = "intitule")
 private  String intitule;

 @Column(name = "acquereur")
 private String acquereur;

 @Column(name = "vendeur")
 private String vendeur;

 @Column(name = "typeacteimmo")
 private String typeActeImmo;

 @Column(name = "mandataire")
 private String mandataire;

 @Column(name = "commentaire")
 private String commentaire;

 @OneToMany(mappedBy = "acteimmo")
 @JsonIgnore
 private List<Documents> documents;
}
