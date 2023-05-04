package com.notaris.soro.dto;

import com.notaris.soro.models.Adresse;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDTO {
    private String adresse1;

    private String adresse2;

    private String codePostal;

    private String pays;

    private String ville;

    public static AdresseDTO toEntityDTO(Adresse adresse){
        if(adresse == null){
            return null;
        }
        return AdresseDTO.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .codePostal(adresse.getCodePostal())
                .pays(adresse.getPays())
                .ville(adresse.getVille())
                .build();
    }


    public static Adresse toEntity(AdresseDTO adresseDto){
        if(adresseDto ==  null){
            return null;
        }
        return Adresse.builder()
                .adresse1(adresseDto.getAdresse1())
                .adresse2(adresseDto.getAdresse2())
                .codePostal(adresseDto.getCodePostal())
                .pays(adresseDto.getPays())
                .ville(adresseDto.getVille())
                .build();
    }
}
