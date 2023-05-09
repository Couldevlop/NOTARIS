package com.notaris.soro.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "cs_responsemessage")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Integer id;
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }
}
