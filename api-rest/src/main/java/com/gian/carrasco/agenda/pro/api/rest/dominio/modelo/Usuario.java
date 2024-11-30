package com.gian.carrasco.agenda.pro.api.rest.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    private Integer id;
    private String nombre;
    private String clave;
    private String rol;
    private Boolean activo;
}