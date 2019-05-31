package com.example.mobilecontrol.LogicaNegocio;

import java.io.Serializable;
import java.util.Objects;

public class Curso implements Serializable {
    String codigo;
    Ciclo codigo_ciclo;
    Carrera codigo_carrera;
    String nombre;
    int creditos;
    int horas;

    public Curso() {
    }

    public Curso(String codigo, Ciclo codigo_ciclo, Carrera codigo_carrera, String nombre, int creditos, int horas) {
        this.codigo = codigo;
        this.codigo_ciclo = codigo_ciclo;
        this.codigo_carrera = codigo_carrera;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas = horas;
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Ciclo getCodigo_ciclo() {
        return codigo_ciclo;
    }

    public void setCodigo_ciclo(Ciclo codigo_ciclo) {
        this.codigo_ciclo = codigo_ciclo;
    }

    public Carrera getCodigo_carrera() {
        return codigo_carrera;
    }

    public void setCodigo_carrera(Carrera codigo_carrera) {
        this.codigo_carrera = codigo_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return creditos == curso.creditos &&
                horas == curso.horas &&
                Objects.equals(codigo, curso.codigo) &&
                Objects.equals(codigo_ciclo, curso.codigo_ciclo) &&
                Objects.equals(codigo_carrera, curso.codigo_carrera) &&
                Objects.equals(nombre, curso.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, codigo_ciclo, codigo_carrera, nombre, creditos, horas);
    }
}
