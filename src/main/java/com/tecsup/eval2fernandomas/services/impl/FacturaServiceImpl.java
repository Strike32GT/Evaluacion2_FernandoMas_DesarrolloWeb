package com.tecsup.eval2fernandomas.services.impl;

import com.tecsup.eval2fernandomas.model.Factura;
import com.tecsup.eval2fernandomas.repository.FacturaRepository;
import com.tecsup.eval2fernandomas.services.FacturaService;

import java.util.List;

public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }


    @Override
    public Factura registrar(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public Factura actualizar(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public void eliminar(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public Factura obtenerPorId(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Factura> listar() {
        return facturaRepository.findAll();
    }
}
