package com.tecsup.eval2fernandomas.services.impl;

import com.tecsup.eval2fernandomas.model.Bitacora;
import com.tecsup.eval2fernandomas.repository.BitacoraRepository;
import com.tecsup.eval2fernandomas.services.BitacoraService;

import java.util.List;

public class BitacoraServiceImpl implements BitacoraService {

    private final BitacoraRepository bitacoraRepository;

    public BitacoraServiceImpl(BitacoraRepository bitacoraRepository) {
        this.bitacoraRepository = bitacoraRepository;
    }


    @Override
    public Bitacora registrar(Bitacora bitacora) {
        return null;
    }

    @Override
    public Bitacora actualizar(Bitacora bitacora) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public Bitacora obtenerPorId(Long id) {
        return null;
    }

    @Override
    public List<Bitacora> listar() {
        return null;
    }
}
