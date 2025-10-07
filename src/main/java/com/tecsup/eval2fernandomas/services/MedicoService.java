package com.tecsup.eval2fernandomas.services;

import com.tecsup.eval2fernandomas.model.Factura;
import com.tecsup.eval2fernandomas.model.Medico;

import java.util.List;

public interface MedicoService {
    Medico registrar(Medico medico);
    Medico actualizar(Medico medico);
    void eliminar(Long id);
    Medico obtenerPorId(Long id);
    List<Medico> listar();
}
