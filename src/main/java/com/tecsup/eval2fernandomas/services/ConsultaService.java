package com.tecsup.eval2fernandomas.services;

import com.tecsup.eval2fernandomas.model.Cita;
import com.tecsup.eval2fernandomas.model.Consulta;

import java.util.List;

public interface ConsultaService {
    Consulta registrar(Consulta consulta);
    Consulta actualizar(Consulta consulta);
    void eliminar(Long id);
    Consulta obtenerPorId(Long id);
    List<Consulta> listar();
}
