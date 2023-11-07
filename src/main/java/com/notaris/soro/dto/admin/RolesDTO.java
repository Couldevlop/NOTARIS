package com.notaris.soro.dto.admin;

import com.notaris.soro.enums.ERole;
import lombok.Builder;
import lombok.Data;


import com.notaris.soro.models.Role;

@Data
@Builder
public class RolesDTO {
    private Integer id;
    private String nom;


    public static RolesDTO toEntityDTO(Role role){
        return RolesDTO.builder()
                .id(role.getId())
                .nom(role.getName().name())
                .build();
    }


    public static  Role toDTOEntity(RolesDTO dto){
        Role role = new Role();
        role.setId(dto.getId());
        role.setName(ERole.valueOf(dto.getNom()));
        return role;
    }
}
