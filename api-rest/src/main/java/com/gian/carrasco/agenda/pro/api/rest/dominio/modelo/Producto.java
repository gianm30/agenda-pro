package com.gian.carrasco.agenda.pro.api.rest.dominio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto {
    private Integer id;
    private String nombre;
    private Integer cantidad;
    private Double precio;
    private Marca marca;
    private Categoria categoria;
    private LocalDateTime fechaCreacion;
}