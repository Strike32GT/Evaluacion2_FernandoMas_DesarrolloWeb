package com.tecsup.eval2fernandomas.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

public class AntecedenteMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAntecedente;

    @ManyToOne
    @JoinColumn(name = "idHistoria")
    private HistoriaClinica historiaClinica;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private String descripcion;

    public enum Tipo{
        alergias,enfermedades_previas,cirugias
    }

    public Long getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Long idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
