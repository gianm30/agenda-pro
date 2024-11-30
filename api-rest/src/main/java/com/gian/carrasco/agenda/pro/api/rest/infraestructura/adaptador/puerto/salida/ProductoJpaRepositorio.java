package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.puerto.salida;

import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.ProductoEntidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoJpaRepositorio extends
        JpaRepository<ProductoEntidad, Integer> {
    @Query("" +
            " SELECT p" +
            " FROM ProductoEntidad p" +
            " JOIN FETCH p.categoria" +
            " JOIN FETCH p.marca")
    Page<ProductoEntidad> findAll(Pageable pageable);

    @Query("" +
            " SELECT p" +
            " FROM ProductoEntidad p" +
            " JOIN FETCH p.categoria" +
            " JOIN FETCH p.marca" +
            " WHERE p.nombre LIKE %?1%")
    List<ProductoEntidad> findByNombreContaining(String nombre);
}