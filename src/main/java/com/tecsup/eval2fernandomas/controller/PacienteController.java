package com.tecsup.eval2fernandomas.controller;

import com.tecsup.eval2fernandomas.model.Paciente;
import com.tecsup.eval2fernandomas.services.PacienteService;
import org.springframework.boot.Banner;
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
        return "forward:/layout.html";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<Paciente> obtenerPacientes() {
        return pacienteService.listar();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Paciente obtenerPacientePorId(@PathVariable Long id){
        return pacienteService.obtenerPorId(id);
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


    @GetMapping("/editar/{id}")
    public String editarPaciente(@PathVariable Long id, Model model){
        model.addAttribute("idPaciente",id);
        return "forward:/paciente/editar.html";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public String actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente){
        paciente.setIdPaciente(id);
        pacienteService.actualizar(paciente);
        return "Paciente actualizado correctamente";
    }



    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminarPaciente(@PathVariable Long id){
        pacienteService.eliminar(id);
        return "Paciente eliminado correctamente";
    }

}
