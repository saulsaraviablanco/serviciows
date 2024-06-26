package pe.scotiabank.serviciows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.scotiabank.serviciows.dto.CuentaDTO;
import pe.scotiabank.serviciows.service.CuentaService;

import java.util.List;

@RestController
@RequestMapping("/v1/cuenta")
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/listarCuentas")
    public ResponseEntity<List<CuentaDTO>> getCuentas(){
        return ResponseEntity.ok(this.cuentaService.getAllCuentas());
    }

    @GetMapping("/listarCuentas/{id}")
    public ResponseEntity<CuentaDTO> getCuentaById(@PathVariable Integer id){
        return ResponseEntity.ok(this.cuentaService.getCuentaById(id));
    }

    @PostMapping("/addCuenta")
    public ResponseEntity<CuentaDTO> addCuenta(@RequestBody CuentaDTO cuentaDTO){
        return ResponseEntity.ok(this.cuentaService.addCuenta(cuentaDTO));
    }

    @DeleteMapping("/deleteCuenta/{id}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable Integer id) {
        try {
            boolean isRemoved = cuentaService.deleteCuenta(id);
            if (!isRemoved) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
