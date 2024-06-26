package pe.scotiabank.serviciows.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "Venta")
public class VentaModel{
    @Id
    @Column(name="id_venta",nullable = false)
    private Integer idVenta;

    @Column(name="direccion")
    private String direccion;

    @Column(name="total")
    private float total;
}
