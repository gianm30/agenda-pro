package com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.mapeo;

import org.mapstruct.BeanMapping;
import org.mapstruct.NullValueCheckStrategy;

public interface MapeoBase<Modelo, Dto> {
    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Modelo enModelo(Dto entidad);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Dto enDto(Modelo modelo);
}
