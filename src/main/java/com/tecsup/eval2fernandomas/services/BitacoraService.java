package com.tecsup.eval2fernandomas.services;

import com.tecsup.eval2fernandomas.model.Bitacora;

import java.util.List;

public interface BitacoraService {
    Bitacora registrar(Bitacora bitacora);
    Bitacora actualizar(Bitacora bitacora);
    void eliminar(Long id);
    Bitacora obtenerPorId(Long id);
    List<Bitacora> listar();
}
