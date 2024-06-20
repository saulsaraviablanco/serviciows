package pe.scotiabank.serviciows.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Venta")
public class VentaModel {
    @Id
    @Column(name="id_venta",nullable = false)
    private Integer idVenta;

    @Column(name="direccion")
    private String direccion;

    @Column(name="total")
    private float total;
}
