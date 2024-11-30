package com.gian.carrasco.agenda.pro.api.rest.aplicacion.servicios;

import com.gian.carrasco.agenda.pro.api.rest.aplicacion.puerto.entrada.ProductoCasoUso;
import com.gian.carrasco.agenda.pro.api.rest.dominio.evento.productor.ProductoProductor;
import com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones.NoExisteCategoriaExcepcion;
import com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones.NoExisteMarcaExcepcion;
import com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones.NoHayIdCategoriaExcepcion;
import com.gian.carrasco.agenda.pro.api.rest.dominio.excepciones.NoHayIdMarcaExcepcion;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Categoria;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Marca;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Producto;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.CategoriaRepositorio;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.MarcaRepositorio;
import com.gian.carrasco.agenda.pro.api.rest.dominio.puerto.salida.ProductoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@RequiredArgsConstructor
public class ProductoServicio implements ProductoCasoUso {
    private final ProductoRepositorio repositorio;
    private final CategoriaRepositorio categoriaRepositorio;
    private final MarcaRepositorio marcaRepositorio;
    private final ProductoProductor productor;

    @Override
    public List<Producto> buscarTodos(int posicionInicial, int filas) {
        return repositorio.buscarTodos(posicionInicial, filas);
    }

    @Override
    public Optional<Producto> buscarPorId(Integer id) {
        return repositorio.buscarPorId(id);
    }

    @Override
    public List<Producto> buscarCoincidenciasPorNombre(String nombre) {
        return repositorio.buscarCoincidenciasPorNombre(nombre);
    }

    @Override
    @Transactional
    public Optional<Producto> crear(Producto modelo) {
        modelo.setCategoria(getCategoria(modelo));
        modelo.setMarca(getMarca(modelo));
        Optional<Producto> rpta = repositorio.crear(modelo);
        if(rpta.isEmpty())
            return empty();

        productor.producirCreacion(rpta.get());
        return rpta;
    }

    @Override
    public Optional<Producto> editar(Producto modelo) {
        modelo.setCategoria(getCategoria(modelo));
        modelo.setMarca(getMarca(modelo));
        return repositorio.editar(modelo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        Optional<Producto> bd = repositorio.buscarPorId(id);
        if(bd.isEmpty())
            return;

        productor.producirEliminacion(bd.get());
        repositorio.eliminarPorId(id);
    }
    
    private Categoria getCategoria(Producto modelo) {
        var idCategoria = of(modelo)
                .map(Producto::getCategoria)
                .map(Categoria::getId)
                .orElseThrow(NoHayIdCategoriaExcepcion::new);

        return categoriaRepositorio.buscarPorId(idCategoria)
                .orElseThrow(NoExisteCategoriaExcepcion::new);
    }

    private Marca getMarca(Producto modelo) {
        var idMarca = of(modelo)
                .map(Producto::getMarca)
                .map(Marca::getId)
                .orElseThrow(NoHayIdMarcaExcepcion::new);

        return marcaRepositorio.buscarPorId(idMarca)
                .orElseThrow(NoExisteMarcaExcepcion::new);
    }
}
