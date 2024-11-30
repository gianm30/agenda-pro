package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.mapeo;

import com.gian.carrasco.agenda.pro.api.rest.dominio.constantes.Constantes;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Estadistica;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.EstadisticaEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = Constantes.PROVEEDOR_MAPEO)
public interface EstadisticaMapeo extends MapeoBase<Estadistica, EstadisticaEntidad> {
}