package com.notaris.soro.models;

import com.notaris.soro.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cs_role")
public class Role extends   AbstractEntity{
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

}
