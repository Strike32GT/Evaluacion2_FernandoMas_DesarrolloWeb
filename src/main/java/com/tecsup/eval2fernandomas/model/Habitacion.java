package com.tecsup.eval2fernandomas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabitacion;

    private String numero;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @OneToMany(mappedBy = "habitacion")
    private List<Hospitalizacion> hospitalizaciones;

    public enum Tipo {
        UCI, general, emergencia
    }

    public enum Estado {
        disponible, ocupada, mantenimiento
    }

    public Long getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Long idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Hospitalizacion> getHospitalizaciones() {
        return hospitalizaciones;
    }

    public void setHospitalizaciones(List<Hospitalizacion> hospitalizaciones) {
        this.hospitalizaciones = hospitalizaciones;
    }
}
