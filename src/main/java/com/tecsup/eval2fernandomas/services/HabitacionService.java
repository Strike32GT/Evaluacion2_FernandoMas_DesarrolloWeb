package com.tecsup.eval2fernandomas.services;

import com.tecsup.eval2fernandomas.model.Habitacion;

import java.util.List;

public interface HabitacionService {
    Habitacion registrar(Habitacion habitacion);
    Habitacion actualizar(Habitacion habitacion);
    void eliminar(Long id);
    Habitacion obtenerPorId(Long id);
    List<Habitacion> listar();
}
