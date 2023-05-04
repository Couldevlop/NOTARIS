package com.notaris.soro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
@Builder
public class Adresse implements Serializable {
    @Column(name = "adresse1")
    private String adresse1;

    @Column(name = "adresse2")
    private String adresse2;

    @Column(name = "codepostal")
    private String codePostal;

    @Column(name = "pays")
    private String pays;

    @Column(name = "ville")
    private String ville;
}
