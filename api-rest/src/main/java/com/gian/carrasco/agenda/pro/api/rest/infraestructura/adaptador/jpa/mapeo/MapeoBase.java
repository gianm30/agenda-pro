package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.mapeo;

import org.mapstruct.BeanMapping;
import org.mapstruct.NullValueCheckStrategy;

public interface MapeoBase<Modelo, Entidad> {
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Modelo enModelo(Entidad entidad);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Entidad enEntidad(Modelo modelo);
}
