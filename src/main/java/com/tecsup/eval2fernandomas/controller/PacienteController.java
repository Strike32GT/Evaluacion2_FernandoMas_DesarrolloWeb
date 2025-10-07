package com.tecsup.eval2fernandomas.controller;

import com.tecsup.eval2fernandomas.model.Paciente;
import com.tecsup.eval2fernandomas.services.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> listar(){
        return pacienteService.listar();
    }

    @GetMapping("/{id}")
    public Paciente obtener(@PathVariable Long id){
        return pacienteService.obtenerPorId(id);
    }

    @PostMapping
    public Paciente registrar(@RequestBody Paciente paciente) {
        return pacienteService.registrar(paciente);
    }

    @PutMapping
    public Paciente actualizar(@RequestBody Paciente paciente) {
        return pacienteService.actualizar(paciente);
    }

    @DeleteMapping
    public void eliminar(@PathVariable Long id) {
        pacienteService.eliminar(id);
    }
}
