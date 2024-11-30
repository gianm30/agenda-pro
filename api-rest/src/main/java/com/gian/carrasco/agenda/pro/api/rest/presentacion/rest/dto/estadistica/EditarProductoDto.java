package com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.dto.estadistica;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Categoria;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Marca;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Producto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EditarProductoDto {
    private int id;
    @NotBlank(message = "Falta nombre")
    private String nombre;
    @NotNull(message = "Falta cantidad")
    @Min(value = 1, message = "La cantidad debe ser mayor o igual a 1")
    private Integer cantidad;
    @NotNull(message = "Falta precio")
    @Min(value = 1, message = "El precio debe ser mayor o igual a 1")
    private Double precio;
    @NotNull(message = "Falta marca")
    @Min(value = 1, message = "La marca debe ser mayor o igual a 1")
    private Integer idMarca;
    @NotNull(message = "Falta categoria")
    @Min(value = 1, message = "La categoria debe ser mayor o igual a 1")
    private Integer idCategoria;

    public Producto enModelo() {
        return Producto.builder()
                .id(id)
                .nombre(nombre)
                .cantidad(cantidad)
                .precio(precio)
                .marca(Marca.builder().id(idMarca).build())
                .categoria(Categoria.builder().id(idCategoria).build())
                .fechaCreacion(LocalDateTime.now())
                .build();
    }
}