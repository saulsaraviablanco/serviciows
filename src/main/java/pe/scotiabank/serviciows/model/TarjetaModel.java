package pe.scotiabank.serviciows.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Tarjetas")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TarjetaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tarjetaId;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private CuentaModel cuenta;

    private String numeroTarjeta;
    private Date fechaExpiracion;
    private String codigoSeguridad;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;


}