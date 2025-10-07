package com.tecsup.eval2fernandomas.model;

import jakarta.persistence.*;

import java.time.*;

@Entity
public class Hospitalizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHosp;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "idHabitacion")
    private Habitacion habitacion;

    private LocalDate fechaIngreso;
    private LocalDate fechaAlta;
    private String diagnosticoIngreso;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public enum Estado {
        activo, dado_de_alta
    }

    public Long getIdHosp() {
        return idHosp;
    }

    public void setIdHosp(Long idHosp) {
        this.idHosp = idHosp;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDiagnosticoIngreso() {
        return diagnosticoIngreso;
    }

    public void setDiagnosticoIngreso(String diagnosticoIngreso) {
        this.diagnosticoIngreso = diagnosticoIngreso;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
