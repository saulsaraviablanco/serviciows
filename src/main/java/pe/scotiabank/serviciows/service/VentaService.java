package pe.scotiabank.serviciows.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.scotiabank.serviciows.dto.PedidoDTO;

import java.util.List;

@Service
public class VentaService {

    public float calculoImpuesto(List<PedidoDTO> listapedidoDTO){

        float impuesto = 0.18f;
        float calculoImpuesto = 0.0f;

        for(PedidoDTO pedidoDTO : listapedidoDTO){
            if(pedidoDTO.isAfectacion()){
                calculoImpuesto += pedidoDTO.getCantidad() * pedidoDTO.getCostoUnitario() * impuesto;
            }
        }


        return calculoImpuesto;
    }
}
