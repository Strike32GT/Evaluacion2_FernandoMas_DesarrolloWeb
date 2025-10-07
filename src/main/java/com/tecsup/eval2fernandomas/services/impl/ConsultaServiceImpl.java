package com.tecsup.eval2fernandomas.services.impl;

import com.tecsup.eval2fernandomas.model.Consulta;
import com.tecsup.eval2fernandomas.repository.ConsultaRepository;
import com.tecsup.eval2fernandomas.services.ConsultaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }


    @Override
    public Consulta registrar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public Consulta actualizar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public void eliminar(Long id) {
        consultaRepository.deleteById(id);
    }

    @Override
    public Consulta obtenerPorId(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Consulta> listar() {
        return consultaRepository.findAll();
    }
}
