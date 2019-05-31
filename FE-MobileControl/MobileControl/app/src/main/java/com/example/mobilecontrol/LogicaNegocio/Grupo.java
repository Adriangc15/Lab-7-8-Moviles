package com.example.mobilecontrol.LogicaNegocio;

import java.io.Serializable;
import java.util.Objects;

public class Grupo implements Serializable{
    private String codigo;
    private Curso curso;
    private Profesor profesor;
    private String horario;

    public Grupo() {
        this.codigo = "";
        this.curso = new Curso();
        this.profesor = new Profesor();
        this.horario = "";
    }

    public Grupo(String codigo, Curso curso, Profesor profesor, String horario) {
        this.codigo = codigo;
        this.curso = curso;
        this.profesor = profesor;
        this.horario = horario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso codigo_curso) {
        this.curso = codigo_curso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String toString() {
        return codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo = (Grupo) o;
        return Objects.equals(codigo, grupo.codigo) &&
                Objects.equals(curso, grupo.curso) &&
                Objects.equals(profesor, grupo.profesor) &&
                Objects.equals(horario, grupo.horario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, curso, profesor, horario);
    }
}
