package com.tecsup.eval2fernandomas.controller;

import com.tecsup.eval2fernandomas.model.Paciente;
import com.tecsup.eval2fernandomas.model.Usuario;
import com.tecsup.eval2fernandomas.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping
    public String usuarioPrincipal(){
        return "forward:/layout.html";
    }

    @GetMapping("/data")
    @ResponseBody
    public List<Usuario> obtenerUsuarios() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Usuario obtenerUsuarioPorId(@PathVariable Long id){
        return usuarioService.obtenerPorId(id);
    }

    // === Carga una vista parcial ===
    @GetMapping("/contenido")
    public String contenidoUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listar());
        return "forward:/usuario/listar.html";
    }

    @PostMapping
    @ResponseBody
    public String crearUsuario(@RequestBody Usuario usuario){
        usuarioService.registrar(usuario);
        return "Usuario creado exitosamente";
    }


    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model){
        model.addAttribute("idUsuario",id);
        return "forward:/usuario/editar.html";
    }


    @PutMapping("/{id}")
    @ResponseBody
    public String actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        usuario.setIdUsuario(id);
        usuarioService.actualizar(usuario);
        return "Usuario actualizado correctamente";
    }



    @DeleteMapping("/{id}")
    @ResponseBody
    public String eliminarUsuario(@PathVariable Long id){
        usuarioService.eliminar(id);
        return "Usuario eliminado correctamente";
    }


}
