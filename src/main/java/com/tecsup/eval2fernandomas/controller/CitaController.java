package com.tecsup.eval2fernandomas.controller;

import com.tecsup.eval2fernandomas.model.Cita;
import com.tecsup.eval2fernandomas.services.CitaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
public class CitaController {
    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public List<Cita> listar(){return citaService.listar();}

    @GetMapping("/{id}")
    public Cita obtener(@PathVariable Long id){return citaService.obtenerPorId(id);}

    @PostMapping
    public Cita registrar(@RequestBody Cita cita){return citaService.registrar(cita);}

    @PutMapping
    public Cita actualizar(@RequestBody Cita cita){return citaService.actualizar(cita);}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){citaService.eliminar(id);}
}
