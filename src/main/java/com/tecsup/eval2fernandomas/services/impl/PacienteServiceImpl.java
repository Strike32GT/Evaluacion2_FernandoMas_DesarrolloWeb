package com.tecsup.eval2fernandomas.services.impl;

import com.tecsup.eval2fernandomas.model.Paciente;
import com.tecsup.eval2fernandomas.repository.PacienteRepository;
import com.tecsup.eval2fernandomas.services.PacienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente registrar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Paciente obtenerPorId(Long id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }
}
