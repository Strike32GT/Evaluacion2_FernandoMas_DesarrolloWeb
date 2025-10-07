package com.tecsup.eval2fernandomas.services.impl;

import com.tecsup.eval2fernandomas.model.Bitacora;
import com.tecsup.eval2fernandomas.repository.BitacoraRepository;
import com.tecsup.eval2fernandomas.services.BitacoraService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BitacoraServiceImpl implements BitacoraService {

    private final BitacoraRepository bitacoraRepository;

    public BitacoraServiceImpl(BitacoraRepository bitacoraRepository) {
        this.bitacoraRepository = bitacoraRepository;
    }


    @Override
    public Bitacora registrar(Bitacora bitacora) {
        return bitacoraRepository.save(bitacora);
    }

    @Override
    public Bitacora actualizar(Bitacora bitacora) {
        return bitacoraRepository.save(bitacora);
    }

    @Override
    public void eliminar(Long id) {
        bitacoraRepository.deleteById(id);
    }

    @Override
    public Bitacora obtenerPorId(Long id) {
        return bitacoraRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bitacora> listar() {
        return bitacoraRepository.findAll();
    }
}
