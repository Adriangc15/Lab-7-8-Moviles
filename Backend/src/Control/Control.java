/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import AccesoDatos.ServicioAlumno;
import AccesoDatos.ServicioGrupo;
import AccesoDatos.ServicioProfesor;
import AccesoDatos.ServicioCarrera;
import AccesoDatos.ServicioCiclo;
import AccesoDatos.ServicioCursos;
import Entidades.Alumno;
import Entidades.Carrera;
import Entidades.Ciclo;
import Entidades.Curso;
import Entidades.Grupo;
import Entidades.Profesor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Guzman
 */
public class Control {
    private ServicioAlumno servicioAlumno;
    private ServicioProfesor servicioProfesor;
    private ServicioGrupo servicioGrupo;
    private ServicioCarrera servicioCarrera;
    private ServicioCiclo servicioCiclos;
    private ServicioCursos servicioCursos;
    private static Control uniqueInstance;
    public static Control instance()
    {
        if (uniqueInstance == null)
        {
            uniqueInstance = new Control();
        }
        return uniqueInstance;
    }
    public Control()
    {
        //servicioProfesor = new ServicioProfesor();
        //servicioAlumno = new ServicioAlumno();
        //servicioGrupo = new ServicioGrupo();
        //servicioCiclos = new ServicioCiclo();
        //servicioCursos = new ServicioCursos();
        //servicioCarrera = new ServicioCarrera();
    }
    ////////////////////////////////////ALUMNOS/////////////////////////////////
    public void insertarAlumno(Alumno alumno) throws Exception{
        servicioAlumno = new ServicioAlumno();
        servicioAlumno.insertarAlumno(alumno);
    }
    
    public void modificarAlumno(Alumno alumno) throws Exception{
        servicioAlumno = new ServicioAlumno();
        servicioAlumno.editarAlumno(alumno);
    }
    
   public void eliminarAlumno(String cedula) throws Exception{
       servicioAlumno = new ServicioAlumno();
        servicioAlumno.eliminarAlumno(cedula);
    }
    
    public ArrayList buscarAlumno(String cedula) throws GlobalException, NoDataException{
        servicioAlumno = new ServicioAlumno();
        return servicioAlumno.buscarAlumno(cedula); 
    }
    
    public ArrayList buscarAlumnoNombre(String nombre) throws GlobalException, NoDataException{
        servicioAlumno = new ServicioAlumno();
        return servicioAlumno.buscarAlumnoNombre(nombre); 
    }
    
    public ArrayList buscarAlumnoCedula(String cedula) throws GlobalException, NoDataException{
        servicioAlumno = new ServicioAlumno();
        return servicioAlumno.buscarAlumnoCedula(cedula); 
    }
    
    public ArrayList listarAlumnos() throws GlobalException, NoDataException{
        servicioAlumno = new ServicioAlumno();
       return  servicioAlumno.listarAlumnos();
    }
    ////////////////////////////////////PROFESORES/////////////////////////////////
    public boolean insertarProfesor(Profesor profesor) throws GlobalException, SQLException{
        servicioProfesor = new ServicioProfesor();
        return servicioProfesor.insertarProfesor(profesor);
    }
    public boolean eliminarProfesor(String cedula) throws GlobalException,SQLException{
        servicioProfesor = new ServicioProfesor();
        return servicioProfesor.eliminarProfesor(cedula);
    }
    public boolean editarProfesor(Profesor profesor) throws GlobalException,SQLException{
        servicioProfesor = new ServicioProfesor();
        return servicioProfesor.editarProfesor(profesor);
    }
    public ArrayList listaProfesores() throws GlobalException, NoDataException{
        servicioProfesor = new ServicioProfesor();
        return servicioProfesor.listaProfesores();
    }
    public Profesor buscarProfesor(String codigo) throws GlobalException, NoDataException{
        servicioProfesor = new ServicioProfesor();
        return servicioProfesor.buscarProfesor(codigo); 
    }
    public List<Profesor> buscarProfesorCedula(String cedula) throws GlobalException, NoDataException{
        servicioProfesor = new ServicioProfesor();
        return (List<Profesor>)servicioProfesor.buscarProfesorCedula(cedula); 
    }
    public List<Profesor> buscarProfesorNombre(String nombre) throws GlobalException, NoDataException{
        servicioProfesor = new ServicioProfesor();
        return (List<Profesor>)servicioProfesor.buscarProfesorNombre(nombre); 
    }
    ////////////////////////////////////GRUPOS/////////////////////////////////
    public void ingresarGrupo(Grupo grupo) throws GlobalException, SQLException, NoDataException{
        servicioGrupo = new ServicioGrupo();
        servicioGrupo.insertarGrupo(grupo);
    }
    public void eliminarGrupo(String codigo) throws GlobalException,SQLException, NoDataException{
        servicioGrupo = new ServicioGrupo();
        servicioGrupo.eliminarGrupo(codigo);
    }
    
    public void modificarGrupo(Grupo grupo) throws GlobalException, SQLException, NoDataException{
        servicioGrupo = new ServicioGrupo();
        servicioGrupo.modificarGrupo(grupo);
    }
        
    public ArrayList listarGrupos() throws GlobalException, NoDataException{
        servicioGrupo = new ServicioGrupo();
        return servicioGrupo.listarGrupos();
    }
    
    //////////////////////////////////CARRERAS///////////////////////////////////
    public void insertarCarrera(Carrera carrera) throws Exception{
        servicioCarrera = new ServicioCarrera();
        servicioCarrera.insertarCarrera(carrera);
    }
    
    public void modificarCarrera(Carrera carrera) throws Exception{
        servicioCarrera = new ServicioCarrera();
        servicioCarrera.modificarCarrera(carrera);
    }
    
   public void eliminarCarrera(String codigo) throws Exception{
       servicioCarrera = new ServicioCarrera();
        servicioCarrera.eliminarCarrera(codigo);
    }
    
    public ArrayList buscarCarreraCodigo(String codigo) throws GlobalException, NoDataException{
        servicioCarrera = new ServicioCarrera();
        return  servicioCarrera.buscarCarreraCodigo(codigo); 
    }
   
    public ArrayList buscarCarreraNombre(String nombre) throws GlobalException, NoDataException{
        servicioCarrera = new ServicioCarrera();
        return servicioCarrera.buscarCarreraNombre(nombre); 
    }
    public Carrera buscarCarreraPorNombre(String nombre) throws GlobalException, NoDataException{
        servicioCarrera = new ServicioCarrera();
        return servicioCarrera.buscarCarreraPorNombre(nombre); 
    }
    public ArrayList listarCarreras()throws GlobalException, NoDataException{
        servicioCarrera = new ServicioCarrera();
        return servicioCarrera.listarCarreras();
    }
   
    public Carrera buscarCarrera(String codigo) throws GlobalException, NoDataException{
        servicioCarrera = new ServicioCarrera();
        return servicioCarrera.buscarCarrera(codigo); 
    }
    
    ///////////////////////////////CICLOS////////////////////////////////////////
    public void insertarCiclo(Ciclo ciclo) throws Exception{
        servicioCiclos = new ServicioCiclo();
        servicioCiclos.insertarCiclo(ciclo);
    }
    
    public void modificarCiclo(Ciclo ciclo) throws Exception{
        servicioCiclos = new ServicioCiclo();
        servicioCiclos.modificarCiclo(ciclo);
    }
    
   public void eliminarCiclo(String codigo) throws Exception{
       servicioCiclos = new ServicioCiclo();
        servicioCiclos.eliminarCiclo(codigo);
    }
       
    public Ciclo buscarCiclo(String codigo) throws GlobalException, NoDataException{
        servicioCiclos = new ServicioCiclo();
        return servicioCiclos.buscarCiclo(codigo); 
    }
    
   public ArrayList listarCiclos()throws GlobalException, NoDataException{
       servicioCiclos = new ServicioCiclo();
        return servicioCiclos.listarCiclos();
    }
    
    public ArrayList buscarCicloCodigo(String codigo) throws GlobalException, NoDataException{
        servicioCiclos = new ServicioCiclo();
        return servicioCiclos.buscarCodigoCiclo(codigo); 
    }
   
    public ArrayList buscarCicloAno(String ano) throws GlobalException, NoDataException{
        servicioCiclos = new ServicioCiclo();
        return servicioCiclos.buscarCicloAno(ano); 
    }
    
///////////////////////////////CURSOS////////////////////////////////////////
     
    public void insertarCurso(Curso curso) throws Exception{
        servicioCursos = new ServicioCursos();
        servicioCursos.insertarCurso(curso);
    }
    
    public void modificarCurso(Curso curso) throws Exception{
        servicioCursos = new ServicioCursos();
        servicioCursos.modificarCurso(curso);
    }
    
   public void eliminarCurso(String codigo) throws Exception{
       servicioCursos = new ServicioCursos();
        servicioCursos.eliminarCurso(codigo);
    }
           
    public ArrayList listarCursos() throws GlobalException, NoDataException{
        servicioCursos = new ServicioCursos();
        return servicioCursos.listarCursos();
    }
      
    public ArrayList buscarCursoCodigo(String codigo) throws GlobalException, NoDataException{
        servicioCursos = new ServicioCursos();
        return servicioCursos.buscarCursoCodigo(codigo); 
    }
    
    public ArrayList buscarCursoNombre(String nombre) throws GlobalException, NoDataException{
        servicioCursos = new ServicioCursos();
        return servicioCursos.buscarCursoNombre(nombre); 
    }
    
    public ArrayList buscarCursoCarrera(String carrera) throws GlobalException, NoDataException{
        servicioCursos = new ServicioCursos();
        return servicioCursos.buscarCursoCarrera(carrera); 
    }
    
    public Curso buscarCurso(String codigo) throws GlobalException, NoDataException{
        servicioCursos = new ServicioCursos();
        return servicioCursos.buscarCurso(codigo); 
    }   
}
