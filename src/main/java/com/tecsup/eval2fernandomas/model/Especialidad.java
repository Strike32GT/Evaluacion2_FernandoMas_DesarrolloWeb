package com.tecsup.eval2fernandomas.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialidad;

    private String nombre;
    private String descripcion;


    @OneToMany(mappedBy = "especialidad")
    private List<MedicoEspecialidad> medicos;

    public Long getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<MedicoEspecialidad> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<MedicoEspecialidad> medicos) {
        this.medicos = medicos;
    }
}
