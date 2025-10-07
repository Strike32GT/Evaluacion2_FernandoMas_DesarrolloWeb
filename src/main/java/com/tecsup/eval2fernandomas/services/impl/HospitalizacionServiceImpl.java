package com.tecsup.eval2fernandomas.services.impl;

import com.tecsup.eval2fernandomas.model.Hospitalizacion;
import com.tecsup.eval2fernandomas.repository.HospitalizacionRepository;
import com.tecsup.eval2fernandomas.services.HospitalizacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalizacionServiceImpl implements HospitalizacionService {

    private final HospitalizacionRepository hospitalizacionRepository;

    public HospitalizacionServiceImpl(HospitalizacionRepository hospitalizacionRepository) {
        this.hospitalizacionRepository = hospitalizacionRepository;
    }


    @Override
    public Hospitalizacion registrar(Hospitalizacion hospitalizacion) {
        return hospitalizacionRepository.save(hospitalizacion);
    }

    @Override
    public Hospitalizacion actualizar(Hospitalizacion hospitalizacion) {
        return hospitalizacionRepository.save(hospitalizacion);
    }

    @Override
    public void eliminar(Long id) {
        hospitalizacionRepository.deleteById(id);
    }

    @Override
    public Hospitalizacion obtenerPorId(Long id) {
        return hospitalizacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Hospitalizacion> listar() {
        return hospitalizacionRepository.findAll();
    }
}
