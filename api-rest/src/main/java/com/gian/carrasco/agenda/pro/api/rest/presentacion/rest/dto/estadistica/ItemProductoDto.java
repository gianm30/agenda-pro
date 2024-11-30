package com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.dto.estadistica;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemProductoDto {
    private int id;
    private String nombre;
    private Integer cantidad;
    private Double precio;
    private Integer idMarca;
    private Integer idCategoria;
    private LocalDateTime fechaCreacion;

    public static ItemProductoDto crear(Producto producto) {
        return ItemProductoDto.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .cantidad(producto.getCantidad())
                .precio(producto.getPrecio())
                .idCategoria(producto.getCategoria().getId())
                .idMarca(producto.getMarca().getId())
                .fechaCreacion(producto.getFechaCreacion())
                .build();
    }
}