package com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida;

import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositorio {
    List<Producto> buscarTodos(int posicionInicial, int filas);

    Optional<Producto> buscarPorId(Integer id);

    List<Producto> buscarCoincidenciasPorNombre(String nombre);

    Optional<Producto> crear(Producto modelo);

    Optional<Producto> editar(Producto modelo);

    void eliminarPorId(Integer id);
}