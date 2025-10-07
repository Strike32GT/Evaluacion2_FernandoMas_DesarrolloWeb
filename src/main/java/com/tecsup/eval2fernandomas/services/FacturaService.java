package com.tecsup.eval2fernandomas.services;

import com.tecsup.eval2fernandomas.model.Factura;

import java.util.List;

public interface FacturaService {
    Factura registrar(Factura factura);
    Factura actualizar(Factura factura);
    void eliminar(Long id);
    Factura obtenerPorId(Long id);
    List<Factura> listar();
}
