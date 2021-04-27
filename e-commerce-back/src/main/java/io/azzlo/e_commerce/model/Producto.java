package io.azzlo.e_commerce.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer cantidad;
}
