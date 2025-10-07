package com.tecsup.eval2fernandomas.services;

import com.tecsup.eval2fernandomas.model.Factura;
import com.tecsup.eval2fernandomas.model.Hospitalizacion;

import java.util.List;

public interface HospitalizacionService {
    Hospitalizacion registrar(Hospitalizacion hospitalizacion);
    Hospitalizacion actualizar(Hospitalizacion hospitalizacion);
    void eliminar(Long id);
    Hospitalizacion obtenerPorId(Long id);
    List<Hospitalizacion> listar();
}
