package com.tecsup.eval2fernandomas.services;

import com.tecsup.eval2fernandomas.model.Factura;
import com.tecsup.eval2fernandomas.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario registrar(Usuario usuario);
    Usuario actualizar(Usuario usuario);
    void eliminar(Long id);
    Usuario obtenerPorId(Long id);
    List<Usuario> listar();
}
