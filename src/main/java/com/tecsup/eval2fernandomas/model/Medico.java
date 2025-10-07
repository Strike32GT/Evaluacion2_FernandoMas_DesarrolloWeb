package com.tecsup.eval2fernandomas.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedico;

    private String nombres;
    private String apellidos;
    private String colegiatura;
    private String telefono;
    private String correo;

    @Enumerated(EnumType.STRING)
    private Estado estado;


    @OneToMany(mappedBy = "medico")
    private List<MedicoEspecialidad> especialidades;

    public enum Estado{
        activo,inactivo
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getColegiatura() {
        return colegiatura;
    }

    public void setColegiatura(String colegiatura) {
        this.colegiatura = colegiatura;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<MedicoEspecialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<MedicoEspecialidad> especialidades) {
        this.especialidades = especialidades;
    }
}
