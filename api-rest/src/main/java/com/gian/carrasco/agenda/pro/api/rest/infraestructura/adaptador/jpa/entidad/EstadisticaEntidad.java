package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estadistica")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstadisticaEntidad {
    @Id
    private Integer id;
    private Integer cantidad;
}