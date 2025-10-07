package com.tecsup.eval2fernandomas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class RecetaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceta;

    @ManyToOne
    @JoinColumn(name = "idConsulta")
    private Consulta consulta;

    private String indicaciones;

    @OneToMany(mappedBy = "recetaMedica")
    private List<DetalleReceta> detalles;

    public Long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Long idReceta) {
        this.idReceta = idReceta;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public List<DetalleReceta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleReceta> detalles) {
        this.detalles = detalles;
    }
}
