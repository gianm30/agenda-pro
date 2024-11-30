package com.gian.carrasco.agenda.pro.api.rest.infraestructura.adaptador.jpa.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Integer cantidad;
    private Double precio;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private MarcaEntidad marca;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntidad categoria;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
}