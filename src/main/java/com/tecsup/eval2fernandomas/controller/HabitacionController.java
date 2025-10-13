package com.tecsup.eval2fernandomas.controller;


import com.tecsup.eval2fernandomas.model.Habitacion;
import com.tecsup.eval2fernandomas.services.HabitacionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/habitacions")
public class HabitacionController {
    private final HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping
    public String habitacionPrincipal(){
        return "forward:/layout.html";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<Habitacion> obtenerHabitaciones() {
        return habitacionService.listar();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Habitacion obtenerHabitacionPorId(@PathVariable Long id){
        return habitacionService.obtenerPorId(id);
    }

    // === Carga una vista parcial ===
    @GetMapping("/contenido")
    public String contenidoHabitaciones(Model model) {
        model.addAttribute("habitacions", habitacionService.listar());
        return "forward:/habitacion/listar.html";
    }

    @PostMapping
    @ResponseBody
    public String crearHabitacion(@RequestBody Habitacion habitacion){
        habitacionService.registrar(habitacion);
        return "Habitacion creada exitosamente";
    }


    @GetMapping("/editar/{id}")
    public String editarHabitacion(@PathVariable Long id, Model model){
        model.addAttribute("idHabitacion",id);
        return "forward:/habitacion/editar.html";
    }

    @PutMapping("/{id}")
    @ResponseBody
    public String actualizarHabitacion(@PathVariable Long id, @RequestBody Habitacion habitacion){
        habitacion.setIdHabitacion(id);
        habitacionService.actualizar(habitacion);
        return "Habitacion actualizada correctamente";
    }



    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminarHabitacion(@PathVariable Long id){
        habitacionService.eliminar(id);
        return "Habitacion eliminada correctamente";
    }
}
