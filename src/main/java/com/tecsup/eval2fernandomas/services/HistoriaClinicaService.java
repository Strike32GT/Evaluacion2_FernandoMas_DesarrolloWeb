package com.tecsup.eval2fernandomas.services;

import com.tecsup.eval2fernandomas.model.Factura;
import com.tecsup.eval2fernandomas.model.HistoriaClinica;

import java.util.List;

public interface HistoriaClinicaService {
    HistoriaClinica registrar(HistoriaClinica historiaClinica);
    HistoriaClinica actualizar(HistoriaClinica historiaClinica);
    void eliminar(Long id);
    HistoriaClinica obtenerPorId(Long id);
    List<HistoriaClinica> listar();
}
