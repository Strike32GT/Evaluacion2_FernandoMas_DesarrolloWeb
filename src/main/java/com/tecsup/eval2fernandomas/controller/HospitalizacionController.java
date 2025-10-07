package com.tecsup.eval2fernandomas.controller;

import com.tecsup.eval2fernandomas.model.Cita;
import com.tecsup.eval2fernandomas.model.Hospitalizacion;
import com.tecsup.eval2fernandomas.services.HospitalizacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitalizacion")
public class HospitalizacionController {

    private final HospitalizacionService hospitalizacionService;

    public HospitalizacionController(HospitalizacionService hospitalizacionService) {
        this.hospitalizacionService = hospitalizacionService;
    }

    @GetMapping
    public List<Hospitalizacion> listar(){return hospitalizacionService.listar();}

    @GetMapping("/{id}")
    public Hospitalizacion obtener(@PathVariable Long id){return hospitalizacionService.obtenerPorId(id);}

    @PostMapping
    public Hospitalizacion registrar(@RequestBody Hospitalizacion hospitalizacion){return hospitalizacionService.registrar(hospitalizacion);}

    @PutMapping
    public Hospitalizacion actualizar(@RequestBody Hospitalizacion hospitalizacion){return hospitalizacionService.actualizar(hospitalizacion);}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){hospitalizacionService.eliminar(id);}
}
