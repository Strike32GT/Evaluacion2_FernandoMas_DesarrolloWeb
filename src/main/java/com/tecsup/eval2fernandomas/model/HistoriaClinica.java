package com.tecsup.eval2fernandomas.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Historia;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    private String fechaApertura;
    private String observaciones;

    @OneToMany(mappedBy = "historiaClinica")
    private List<AntecedenteMedico> antecedentes;

    public Long getHistoria() {
        return Historia;
    }

    public void setHistoria(Long historia) {
        Historia = historia;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<AntecedenteMedico> getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(List<AntecedenteMedico> antecedentes) {
        this.antecedentes = antecedentes;
    }
}
