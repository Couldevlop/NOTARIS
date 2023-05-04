package com.notaris.soro.models;

import com.notaris.soro.enums.TypeActeImmo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cs_acteimmobilier")
public class ActeImmobilier extends AbstractEntity{
 private  String intitule;
 private String acquereur;
 private String vendeur;
 private TypeActeImmo typeActeImmo;
 private String mandataire;
 private String commentaire;
}
