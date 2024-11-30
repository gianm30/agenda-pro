package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.mapeo;

import com.gian.carrasco.agenda.pro.api.rest.dominio.constantes.Constantes;
import com.gian.carrasco.agenda.pro.api.rest.dominio.modelo.Usuario;
import com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad.UsuarioEntidad;
import org.mapstruct.Mapper;

@Mapper(componentModel = Constantes.PROVEEDOR_MAPEO)
public interface UsuarioMapeo extends MapeoBase<Usuario, UsuarioEntidad> {
}