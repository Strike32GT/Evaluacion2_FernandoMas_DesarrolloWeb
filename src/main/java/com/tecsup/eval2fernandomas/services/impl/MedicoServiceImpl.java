package com.tecsup.eval2fernandomas.services.impl;

import com.tecsup.eval2fernandomas.model.Medico;
import com.tecsup.eval2fernandomas.repository.MedicoRepository;
import com.tecsup.eval2fernandomas.services.MedicoService;

import java.util.List;

public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public Medico registrar(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public Medico actualizar(Medico medico) {
        return medicoRepository.save(medico);
    }

    @Override
    public void eliminar(Long id) {
        medicoRepository.deleteById(id);
    }

    @Override
    public Medico obtenerPorId(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Medico> listar() {
        return medicoRepository.findAll();
    }
}
