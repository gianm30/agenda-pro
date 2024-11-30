package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.mapeo;

import com.gian.carrasco.agenda.pro.api.rest.dominio.constantes.Constantes;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Categoria;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.CategoriaEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = Constantes.PROVEEDOR_MAPEO)
public interface CategoriaMapeo extends MapeoBase<Categoria, CategoriaEntidad> {
}