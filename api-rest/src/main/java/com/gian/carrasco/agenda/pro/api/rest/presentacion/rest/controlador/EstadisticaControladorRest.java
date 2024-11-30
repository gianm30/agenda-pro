package com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.controlador;

import com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios.EstadisticaServicio;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Estadistica;
import com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.dto.producto.ItemEstadisticaDto;
import com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.util.UrlUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlUtil.API + UrlUtil.ESTADISTICA)
@RequiredArgsConstructor
public class EstadisticaControladorRest {
    private final EstadisticaServicio servicio;

    @GetMapping("/{id}")
    public ResponseEntity<ItemEstadisticaDto> buscarPorId(
            @PathVariable Integer id) {
        var rpta = servicio.buscarPorId(id);
        if(rpta.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(rpta.map(ItemEstadisticaDto::crear).get());
    }
}