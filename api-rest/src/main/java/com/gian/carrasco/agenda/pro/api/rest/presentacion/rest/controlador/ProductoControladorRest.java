package com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.controlador;

import com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios.ProductoServicio;
import com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.dto.estadistica.CrearProductoDto;
import com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.dto.estadistica.EditarProductoDto;
import com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.dto.estadistica.ItemProductoDto;
import com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.util.UrlUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlUtil.API + UrlUtil.PRODUCTO)
@RequiredArgsConstructor
public class ProductoControladorRest {
    private final ProductoServicio servicio;

    @GetMapping
    public ResponseEntity<List<ItemProductoDto>> buscarTodos(
            @RequestParam int posicionInicial, @RequestParam int filas) {
        if(posicionInicial < 0 || filas > 10)
            return ResponseEntity.badRequest().build();

        var datos = servicio.buscarTodos(posicionInicial, filas)
                .stream()
                .map(ItemProductoDto::crear)
                .toList();
        return ResponseEntity.ok(datos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemProductoDto> buscarPorId(@PathVariable Integer id) {
        var rpta = servicio.buscarPorId(id);
        if(rpta.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(rpta.map(ItemProductoDto::crear).get());
    }

    @GetMapping("/coincidencias")
    public List<ItemProductoDto> buscarCoincidenciasPorNombre(
            @RequestParam String nombre) {
        return servicio.buscarCoincidenciasPorNombre(nombre)
                .stream()
                .map(ItemProductoDto::crear)
                .toList();
    }

    @PostMapping
    public ResponseEntity<ItemProductoDto> crear(
            @Valid @RequestBody CrearProductoDto rq) {
        var rpta = servicio.crear(rq.enModelo());
        if(rpta.isEmpty())
            return ResponseEntity.badRequest().build();

        var dto = rpta.map(ItemProductoDto::crear).get();
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemProductoDto> editar(
            @PathVariable int id,
            @Valid @RequestBody EditarProductoDto rq) {
        var busqueda = servicio.buscarPorId(id);
        if(busqueda.isEmpty())
            return ResponseEntity.notFound().build();

        rq.setId(id);
        var rpta = servicio.editar(rq.enModelo());
        if(rpta.isEmpty())
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(rpta.map(ItemProductoDto::crear).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable Integer id) {
        var busqueda = servicio.buscarPorId(id);
        if(busqueda.isEmpty())
            return ResponseEntity.notFound().build();

        servicio.eliminarPorId(id);

        var rpta = servicio.buscarPorId(id);
        if(rpta.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.internalServerError().build();
    }
}