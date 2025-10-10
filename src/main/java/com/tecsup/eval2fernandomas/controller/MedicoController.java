package com.tecsup.eval2fernandomas.controller;


import com.tecsup.eval2fernandomas.model.Medico;
import com.tecsup.eval2fernandomas.services.MedicoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public String medicoPrincipal(){
        return "forward:/layout.html";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<Medico> obtenerMedicos() {
        return medicoService.listar();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Medico obtenerMedicoPorId(@PathVariable Long id){
        return medicoService.obtenerPorId(id);
    }

    // === Carga una vista parcial ===
    @GetMapping("/contenido")
    public String contenidoMedicos(Model model) {
        model.addAttribute("medicos", medicoService.listar());
        return "forward:/medico/listar.html";
    }

    @PostMapping
    @ResponseBody
    public String crearMedico(@RequestBody Medico medico){
        medicoService.registrar(medico);
        return "Medico creado exitosamente";
    }


    @GetMapping("/editar/{id}")
    public String editarMedico(@PathVariable Long id, Model model){
        model.addAttribute("idMedico",id);
        return "forward:/medico/editar.html";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public String actualizarMedico(@PathVariable Long id, @RequestBody Medico medico){
        medico.setIdMedico(id);
        medicoService.actualizar(medico);
        return "Medico actualizado correctamente";
    }



    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminarMedico(@PathVariable Long id){
        medicoService.eliminar(id);
        return "Medico eliminado correctamente";
    }

}
