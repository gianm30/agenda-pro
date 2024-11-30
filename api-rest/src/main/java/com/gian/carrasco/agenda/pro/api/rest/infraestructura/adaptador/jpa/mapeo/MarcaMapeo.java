package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.mapeo;

import com.gian.carrasco.agenda.pro.api.rest.dominio.constantes.Constantes;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Marca;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.MarcaEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = Constantes.PROVEEDOR_MAPEO)
public interface MarcaMapeo extends MapeoBase<Marca, MarcaEntidad> {
}