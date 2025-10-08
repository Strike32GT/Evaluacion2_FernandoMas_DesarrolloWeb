package com.tecsup.eval2fernandomas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "AntecedenteMedico")
public class AntecedenteMedico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAntecedente")
    private Long idAntecedente;

    @ManyToOne
    @JoinColumn(name = "idHistoria",referencedColumnName = "idHistoria")
    private HistoriaClinica historiaClinica;

    @Column(name = "tipo")
    private String tipo;
    @Column(name = "descripcion")
    private String descripcion;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
