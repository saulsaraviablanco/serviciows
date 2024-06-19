package pe.scotiabank.serviciows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.scotiabank.serviciows.dto.PedidoDTO;
import pe.scotiabank.serviciows.service.VentaService;

@RestController
@RequestMapping("/v1/venta")
public class VentaController {

    @Autowired
    VentaService ventaService;

    @PostMapping("/calculoImpuesto")
    public ResponseEntity<Float> calculoImpuesto(@RequestBody PedidoDTO pedidoDTO){
        return new ResponseEntity<>(ventaService.calculoImpuesto(pedidoDTO), HttpStatus.OK);
    }
}
