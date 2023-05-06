package com.notaris.soro.dto;

import com.notaris.soro.enums.TypeActeImmo;
import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.ActeImmobilier;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ActeImmobilierDTO{
 private Integer id;
 private  String intitule;
 private String acquereur;
 private String vendeur;
 private TypeActeImmo typeActeImmo;
 private String mandataire;
 private String commentaire;
 private List<DocumentsDTO> documentsDTOList;


 public static ActeImmobilierDTO toEntityDTO(ActeImmobilier acteImmobilier){
  if(acteImmobilier == null){
   return null;
  }
  return ActeImmobilierDTO.builder()
          .id(acteImmobilier.getId())
          .acquereur(acteImmobilier.getAcquereur())
          .commentaire(acteImmobilier.getCommentaire())
          .intitule(acteImmobilier.getIntitule())
          .mandataire(acteImmobilier.getMandataire())
          .vendeur(acteImmobilier.getVendeur())
          .typeActeImmo(acteImmobilier.getTypeActeImmo())
          .documentsDTOList(
                  acteImmobilier.getDocuments() != null ? acteImmobilier.getDocuments().
                          stream().map(DocumentsDTO::toEntityDTO).collect(Collectors.toList()):null
          )
          .build();
 }

 public static  ActeImmobilier toEntity(ActeImmobilierDTO dto){
  if(dto == null){
   return null;
  }
  ActeImmobilier  acteImmobilier = new ActeImmobilier();
  acteImmobilier.setId(dto.getId());
  acteImmobilier.setAcquereur(dto.getAcquereur());
  acteImmobilier.setCommentaire(dto.getCommentaire());
  acteImmobilier.setTypeActeImmo(dto.typeActeImmo);
  acteImmobilier.setIntitule(dto.getIntitule());
  acteImmobilier.setVendeur(dto.getVendeur());
  acteImmobilier.setMandataire(dto.getMandataire());
  return acteImmobilier;
 }
}