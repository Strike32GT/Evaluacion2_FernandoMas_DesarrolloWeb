package com.tecsup.eval2fernandomas.services.impl;

import com.tecsup.eval2fernandomas.model.Cita;
import com.tecsup.eval2fernandomas.repository.CitaRepository;
import com.tecsup.eval2fernandomas.services.CitaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    private final CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }


    @Override
    public Cita registrar(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public Cita actualizar(Cita cita) {
        return citaRepository.save(cita);
    }

    @Override
    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }

    @Override
    public Cita obtenerPorId(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cita> listar() {
        return citaRepository.findAll();
    }
}
