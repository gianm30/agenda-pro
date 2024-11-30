package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida.impl;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Producto;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.ProductoRepositorio;
import com.gian.carrasco.agenda.pro.api.rest.dominio.util.IntUtil;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida.ProductoJpaRepositorio;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.mapeo.ProductoMapeo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;

@Repository
@RequiredArgsConstructor
public class ProductoRepositorioImpl implements ProductoRepositorio {
    private final ProductoJpaRepositorio jpa;
    private final ProductoMapeo mapeo;

    @Override
    public List<Producto> buscarTodos(int posicionInicial, int filas) {
        int pagina = posicionInicial / filas;
        return jpa.findAll(PageRequest.of(pagina, filas))
                .map(mapeo::enModelo)
                .toList();
    }

    @Override
    public Optional<Producto> buscarPorId(Integer id) {
        return jpa.findById(id).map(mapeo::enModelo);
    }

    @Override
    public List<Producto> buscarCoincidenciasPorNombre(String nombre) {
        return jpa.findByNombreContaining(nombre)
                .stream()
                .map(mapeo::enModelo)
                .toList();
    }

    @Override
    public Optional<Producto> crear(Producto modelo) {
        var bd = ofNullable(modelo).map(mapeo::enEntidad);
        if(bd.isEmpty())
            return empty();

        var entidad = bd.get();
        entidad.setId(null);
        return of(jpa.save(entidad)).map(mapeo::enModelo);
    }

    @Override
    public Optional<Producto> editar(Producto modelo) {
        var bd = ofNullable(modelo)
                .filter(x -> IntUtil.esMayorACero(x.getId()))
                .map(mapeo::enEntidad);
        if(bd.isEmpty())
            return empty();

        var entidad = bd.get();
        return of(jpa.save(entidad)).map(mapeo::enModelo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        jpa.deleteById(id);
    }
}