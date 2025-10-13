package com.tecsup.eval2fernandomas.services.impl;

import com.tecsup.eval2fernandomas.model.Habitacion;
import com.tecsup.eval2fernandomas.repository.HabitacionRepository;
import com.tecsup.eval2fernandomas.services.HabitacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionServiceImpl implements HabitacionService {
    private final HabitacionRepository habitacionRepository;

    public HabitacionServiceImpl(HabitacionRepository habitacionRepository) {
        this.habitacionRepository = habitacionRepository;
    }


    @Override
    public Habitacion registrar(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    @Override
    public Habitacion actualizar(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    @Override
    public void eliminar(Long id) {
        habitacionRepository.deleteById(id);
    }

    @Override
    public Habitacion obtenerPorId(Long id) {
        return habitacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Habitacion> listar() {
        return habitacionRepository.findAll();
    }
}
