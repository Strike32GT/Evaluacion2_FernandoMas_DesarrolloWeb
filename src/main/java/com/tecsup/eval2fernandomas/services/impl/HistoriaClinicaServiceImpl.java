package com.tecsup.eval2fernandomas.services.impl;

import com.tecsup.eval2fernandomas.model.HistoriaClinica;
import com.tecsup.eval2fernandomas.repository.HistoriaClinicaRepository;
import com.tecsup.eval2fernandomas.services.HistoriaClinicaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    private final HistoriaClinicaRepository historiaClinicaRepository;

    public HistoriaClinicaServiceImpl(HistoriaClinicaRepository historiaClinicaRepository) {
        this.historiaClinicaRepository = historiaClinicaRepository;
    }


    @Override
    public HistoriaClinica registrar(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Override
    public HistoriaClinica actualizar(HistoriaClinica historiaClinica) {
        return historiaClinicaRepository.save(historiaClinica);
    }

    @Override
    public void eliminar(Long id) {
        historiaClinicaRepository.deleteById(id);
    }

    @Override
    public HistoriaClinica obtenerPorId(Long id) {
        return historiaClinicaRepository.findById(id).orElse(null);
    }

    @Override
    public List<HistoriaClinica> listar() {
        return historiaClinicaRepository.findAll();
    }
}
