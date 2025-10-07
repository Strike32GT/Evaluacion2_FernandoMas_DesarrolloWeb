package com.tecsup.eval2fernandomas.controller;

import com.tecsup.eval2fernandomas.model.Paciente;
import com.tecsup.eval2fernandomas.model.Usuario;
import com.tecsup.eval2fernandomas.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id){
        return usuarioService.obtenerPorId(id);
    }

    @PostMapping
    public Usuario registrar(@RequestBody Usuario usuario) {
        return usuarioService.registrar(usuario);
    }

    @PutMapping
    public Usuario actualizar(@RequestBody Usuario usuario) {
        return usuarioService.actualizar(usuario);
    }

    @DeleteMapping
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }
}
