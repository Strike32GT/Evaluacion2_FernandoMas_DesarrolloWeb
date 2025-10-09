package com.tecsup.eval2fernandomas.controller;

import com.tecsup.eval2fernandomas.model.Paciente;
import com.tecsup.eval2fernandomas.services.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public String pacientePrincipal(){
        return "layout";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<Paciente> obtenerPacientes() {
        return pacienteService.listar();
    }

    // === Carga una vista parcial ===
    @GetMapping("/contenido")
    public String contenidoPacientes(Model model) {
        model.addAttribute("pacientes", pacienteService.listar());
        return "forward:/paciente/listar.html";
    }

    @PostMapping
    @ResponseBody
    public String crearPaciente(@RequestBody Paciente paciente){
        pacienteService.registrar(paciente);
        return "Paciente creado exitosamente";
    }


    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminarPaciente(@PathVariable Long id){
        pacienteService.eliminar(id);
        return "Paciente eliminado correctamente";
    }

}
