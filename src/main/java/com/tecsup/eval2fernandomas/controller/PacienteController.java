package com.tecsup.eval2fernandomas.controller;

import com.tecsup.eval2fernandomas.model.Paciente;
import com.tecsup.eval2fernandomas.services.PacienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("pacientes",pacienteService.listar());
        model.addAttribute("pageCss","/pacientes.css");
        model.addAttribute("contentFragment", "paciente/listar :: content");
        return "layout";
    }



}
