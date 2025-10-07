package com.tecsup.eval2fernandomas.controller;

import com.tecsup.eval2fernandomas.model.Cita;
import com.tecsup.eval2fernandomas.model.Factura;
import com.tecsup.eval2fernandomas.services.FacturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> listar(){return facturaService.listar();}

    @GetMapping("/{id}")
    public Factura obtener(@PathVariable Long id){return facturaService.obtenerPorId(id);}

    @PostMapping
    public Factura registrar(@RequestBody Factura factura){return facturaService.registrar(factura);}

    @PutMapping
    public Factura actualizar(@RequestBody Factura factura){return facturaService.actualizar(factura);}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){facturaService.eliminar(id);}
}
