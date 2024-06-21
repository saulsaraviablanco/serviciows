package pe.scotiabank.serviciows.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.scotiabank.serviciows.dto.PedidoDTO;
import pe.scotiabank.serviciows.dto.VentaDTO;
import pe.scotiabank.serviciows.model.VentaModel;
import pe.scotiabank.serviciows.repository.VentaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;
    private final ModelMapper modelMapper;

    public VentaService(VentaRepository ventaRepository, ModelMapper modelMapper) {
        this.ventaRepository = ventaRepository;
        this.modelMapper = modelMapper;
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

    public List<VentaDTO> getVentas(){
        List<VentaModel> listaVentas = this.ventaRepository.findAll();
        List<VentaDTO> listaVentaDTO = modelMapper.map(listaVentas, List.class).stream().toList();
        return listaVentaDTO;
    }
}
