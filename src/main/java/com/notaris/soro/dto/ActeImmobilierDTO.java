package com.notaris.soro.dto;

import com.notaris.soro.enums.TypeActeImmo;
import com.notaris.soro.models.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class ActeImmobilierDTO{
 private  String intitule;
 private String acquereur;
 private String vendeur;
 private TypeActeImmo typeActeImmo;
 private String mandataire;
 private String commentaire;
}
