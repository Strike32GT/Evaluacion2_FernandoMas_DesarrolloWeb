package com.tecsup.eval2fernandomas.services;

import com.tecsup.eval2fernandomas.model.Cita;

import java.util.List;

public interface CitaService {
    Cita registrar(Cita cita);
    Cita actualizar(Cita cita);
    void eliminar(Long id);
    Cita obtenerPorId(Long id);
    List<Cita> listar();
}
