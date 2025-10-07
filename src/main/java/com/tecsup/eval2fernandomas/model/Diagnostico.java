package com.tecsup.eval2fernandomas.model;
import jakarta.persistence.*;

@Entity
public class Diagnostico {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idDiagnostico;

        @ManyToOne
        @JoinColumn(name = "idConsulta")
        private Consulta consulta;

        private String descripcion;

        @Enumerated(EnumType.STRING)
        private Tipo tipo;

        public enum Tipo {
            presuntivo, definitivo
        }

    public Long getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Long idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
