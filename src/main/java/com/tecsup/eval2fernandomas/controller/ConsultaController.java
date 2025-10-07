package com.tecsup.eval2fernandomas.controller;

import com.tecsup.eval2fernandomas.model.Cita;
import com.tecsup.eval2fernandomas.model.Consulta;
import com.tecsup.eval2fernandomas.services.ConsultaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping
    public List<Consulta> listar(){return consultaService.listar();}

    @GetMapping("/{id}")
    public Consulta obtener(@PathVariable Long id){return consultaService.obtenerPorId(id);}

    @PostMapping
    public Consulta registrar(@RequestBody Consulta consulta){return consultaService.registrar(consulta);}

    @PutMapping
    public Consulta actualizar(@RequestBody Consulta consulta){return consultaService.actualizar(consulta);}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){consultaService.eliminar(id);}

}
