package com.tecsup.eval2fernandomas.services;

import com.tecsup.eval2fernandomas.model.Paciente;

import java.util.List;

public interface PacienteService {
    Paciente registrar(Paciente paciente);
    Paciente actualizar(Paciente paciente);
    void eliminar(Long id);
    Paciente obtenerPorId(Long id);
    List<Paciente> listar();
}
