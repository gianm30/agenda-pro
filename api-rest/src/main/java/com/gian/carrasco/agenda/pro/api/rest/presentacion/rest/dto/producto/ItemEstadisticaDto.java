package com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.dto.producto;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Estadistica;
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
public class ItemEstadisticaDto {
    private Integer productos;

    public static ItemEstadisticaDto crear(Estadistica estadistica) {
        return ItemEstadisticaDto.builder()
                .productos(estadistica.getCantidad())
                .build();
    }
}