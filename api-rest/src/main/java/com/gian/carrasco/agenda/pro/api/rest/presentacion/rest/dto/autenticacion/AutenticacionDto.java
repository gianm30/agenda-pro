package com.gian.carrasco.agenda.pro.api.rest.presentacion.rest.dto.autenticacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutenticacionDto {
    private String token;
    private String inicio;
    private String expiracion;
    private Integer duracion;
}