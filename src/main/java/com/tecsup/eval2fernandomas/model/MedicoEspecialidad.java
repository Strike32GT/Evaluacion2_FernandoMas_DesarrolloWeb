package com.tecsup.eval2fernandomas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MedicoEspecialidad")
public class MedicoEspecialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicoEsp;

    @ManyToOne
    @JoinColumn(name = "idMedico")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;

    public Long getIdMedicoEsp() {
        return idMedicoEsp;
    }

    public void setIdMedicoEsp(Long idMedicoEsp) {
        this.idMedicoEsp = idMedicoEsp;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
