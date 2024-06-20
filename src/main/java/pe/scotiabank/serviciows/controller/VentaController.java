package pe.scotiabank.serviciows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.scotiabank.serviciows.dto.PedidoDTO;
import pe.scotiabank.serviciows.model.VentaModel;
import pe.scotiabank.serviciows.service.VentaService;

import java.util.List;

@RestController
@RequestMapping("/v1/venta")
public class VentaController {

    @Autowired
    VentaService ventaService;

    @PostMapping("/calculoImpuesto")
    public ResponseEntity<Float> calculoImpuesto(@RequestBody List<PedidoDTO> listaPedidoDTO){
        return new ResponseEntity<>(ventaService.calculoImpuesto(listaPedidoDTO), HttpStatus.OK);
    }

    @GetMapping("/getVentas")
    public ResponseEntity<List<VentaModel>> getVentas(){
        return new ResponseEntity<>(ventaService.getVentas(),HttpStatus.OK);
    }
}
