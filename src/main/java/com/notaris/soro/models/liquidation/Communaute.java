package com.notaris.soro.models.liquidation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.dto.DocumentsDTO;
import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.Documents;
import com.notaris.soro.models.DocumentsCommunaute;
import com.notaris.soro.models.clients.Physique;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cs_liquidationcommunaute")
public class Communaute extends AbstractEntity implements Serializable {

    @Column(name = "intitule")
    private String intitule;

    @Column(name = "dateouverture")
    private LocalDate dateOuverture;

    @Column(name = "client")
    private String client;

    @Column(name = "commentaire")
    private String commentaire;

    @OneToMany(mappedBy = "doccommunuate")
    @JsonIgnore
    private List<DocumentsCommunaute> documents;

}
