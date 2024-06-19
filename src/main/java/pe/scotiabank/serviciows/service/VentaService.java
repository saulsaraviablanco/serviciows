package pe.scotiabank.serviciows.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.scotiabank.serviciows.dto.PedidoDTO;

@Service
public class VentaService {

    public float calculoImpuesto(PedidoDTO pedidoDTO){

        float impuesto = 0.18f;
        float calculoImpuesto = 0.0f;

        if(pedidoDTO.isAfectacion()){
            calculoImpuesto=pedidoDTO.getCantidad()*pedidoDTO.getCostoUnitario()*impuesto;
        }
        return calculoImpuesto;
    }
}
