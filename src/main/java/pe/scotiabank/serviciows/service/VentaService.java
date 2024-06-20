package pe.scotiabank.serviciows.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.scotiabank.serviciows.dto.PedidoDTO;
import pe.scotiabank.serviciows.model.VentaModel;
import pe.scotiabank.serviciows.repository.VentaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;

    public VentaService(VentaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }


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

    public List<VentaModel> getVentas(){
        List<VentaModel> listaVentas = this.ventaRepository.findAll();
        return listaVentas;
    }
}
