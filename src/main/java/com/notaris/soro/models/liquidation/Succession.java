package com.notaris.soro.models.liquidation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.DocumentsSuccession;
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
@Table(name = "cs_liguidationsuccession")
public class Succession extends AbstractEntity implements Serializable {

    @Column(name = "intitule")
    private String intitule;

    @Column(name = "typeSuccession")
    private String typeSuccession;

    @Column(name = "dateOuverture")
    private LocalDate dateOuverture;

   @Column(name = "client")
    private String client;

    @Column(name = "commentaire")
    private String commentaire;

    @OneToMany(mappedBy = "docsuccession")
    @JsonIgnore
    private List<DocumentsSuccession> documents;
}
