package com.notaris.soro.models.societe;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notaris.soro.models.AbstractEntity;
import com.notaris.soro.models.Documents;
import com.notaris.soro.models.DocumentsModifSociete;
import com.notaris.soro.models.admin.TypeSociete;
import com.notaris.soro.models.clients.Physique;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cs_modificationsociete")
public class Modification extends AbstractEntity implements Serializable {

    @Column(name = "objet")
    private String objet;

    @Column(name = "client")
    private String client;

    @Column(name = "natureSociete")
    private String natureSociete;

    @Column(name = "typeSociete")
    private String typeSociete;

    @Column(name = "motif")
    private String motif;

    @Column(name = "dateouverture")
    private LocalDate dateOuverture;

 /*   @JsonIgnore
    @OneToMany(mappedBy = "modifscte")
    private List<DocumentsModifSociete> documents;*/
}
