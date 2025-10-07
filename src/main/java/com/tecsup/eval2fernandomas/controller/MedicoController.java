package com.tecsup.eval2fernandomas.controller;

import com.tecsup.eval2fernandomas.model.Cita;
import com.tecsup.eval2fernandomas.model.Medico;
import com.tecsup.eval2fernandomas.services.MedicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public List<Medico> listar(){return medicoService.listar();}

    @GetMapping("/{id}")
    public Medico obtener(@PathVariable Long id){return medicoService.obtenerPorId(id);}

    @PostMapping
    public Medico registrar(@RequestBody Medico medico){return medicoService.registrar(medico);}

    @PutMapping
    public Medico actualizar(@RequestBody Medico medico){return medicoService.actualizar(medico);}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){medicoService.eliminar(id);}
}
