package pe.scotiabank.serviciows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.scotiabank.serviciows.dto.PedidoDTO;
import pe.scotiabank.serviciows.dto.VentaDTO;
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
    public ResponseEntity<List<VentaDTO>> getVentas(){
        return new ResponseEntity<>(ventaService.getVentas(),HttpStatus.OK);
    }

    @PostMapping("/addVentas")
    public ResponseEntity<VentaDTO> addVenta(@RequestBody VentaDTO ventaDTO){
        return new ResponseEntity<>(ventaService.addVenta(ventaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/deleteVentas/{id}")
    public ResponseEntity<Void> deleteVenta(@PathVariable Long id) {
        try {
            boolean isRemoved = ventaService.deleteVenta(id);
            if (!isRemoved) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
