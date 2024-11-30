package com.gian.carrasco.agenda.pro.api.rest.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Marca {
    private Integer id;
    private String nombre;
}