/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import Control.Control;
import Entidades.Carrera;
import Entidades.Ciclo;
import Entidades.Curso;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "ServiceCurso", urlPatterns = {"/ServiceCurso"})
public class ServiceCurso extends HttpServlet {
    
    private Control control = new Control();
    private String cursosJsonString;
    private String ciclosJsonString;   
    private String carrerasJsonString;
    ArrayList<Curso> cursos;
    ArrayList<Carrera> carreras;
    ArrayList<Ciclo> ciclos;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            doGet(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        Gson gson = new Gson();
        PrintWriter out = resp.getWriter();
        // Adding new elements to the ArrayList
        String opcion = (String) req.getParameter("opc");
        switch (Integer.parseInt(opcion)) {
            //Listar Cursos
            case 1:
            try {
                cursos = getListCursos();
            } catch (Exception ex) {
                Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                cursosJsonString = gson.toJson(cursos);
                try {
                    out.println(cursosJsonString);
                } finally {
                    out.close();
                }
                break;
            //Agregar Curso
            case 2:
                
                Curso c = new Curso();
                try {
                        c.setCodigo(req.getParameter("codigo"));
                        c.setCodigo_ciclo(buscarCiclo(req.getParameter("codigoCiclo")));
                        c.setCodigo_carrera(buscarCarrera(req.getParameter("codigoCarrera")));
                        c.setNombre(req.getParameter("nombre"));
                        c.setCreditos(Integer.parseInt(req.getParameter("creditos")));
                        c.setHoras(req.getParameter("horas"));
                    
                     if(ingresarCurso(c)){
                                    try {
                                        cursos = getListCursos();
                                        } catch (Exception ex) {
                                            Logger.getLogger(ServiceCurso.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                            cursosJsonString = gson.toJson(cursos);
                                            try {
                                                out.println(cursosJsonString);
                                            } finally {
                                                out.close();
                                            }                           
                    }else{
                         out.println("Error al agregar");                      
                    }
                }catch(Exception e){
                    System.out.println("Error "+e);
                }

                break;
            //Elimina Curso
            case 3:
                try {
                    String codEliminar = req.getParameter("codigo");
                if(eliminarCurso(codEliminar)){
                      out.println("curso eliminado");
                }else{
                      out.println("error al eliminar");              
                }
                
            }catch(Exception e){
                System.out.println(""+e);
                Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, e);
            }
                break;
            //Edita Curso
            case 4:
            try{
                String codigoEditar = req.getParameter("codigo");
                String nombreEditar = req.getParameter("nombre");
                cursos = getListCursos();
                Curso cursoEditar = null;
                if(nombreEditar == null){
                    if(buscarCurso(cursos, codigoEditar) != null){
                        cursoEditar = buscarCurso(cursos, codigoEditar);
                    }
                }else{
                    cursoEditar = new Curso();
                    cursoEditar.setCodigo(req.getParameter("codigo"));
                    cursoEditar.setCodigo_ciclo(buscarCiclo(req.getParameter("codigoCiclo")));
                    cursoEditar.setCodigo_carrera(buscarCarrera(req.getParameter("codigoCarrera")));
                    cursoEditar.setNombre(req.getParameter("nombre"));
                    cursoEditar.setCreditos(Integer.parseInt(req.getParameter("creditos")));
                    cursoEditar.setHoras(req.getParameter("horas"));
                    
                    if(modificarCurso(cursoEditar)){
                         try {
                                        cursos = getListCursos();
                                        } catch (Exception ex) {
                                            Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                            cursosJsonString = gson.toJson(cursos);
                                            try {
                                                out.println(cursosJsonString);
                                            } finally {
                                                out.close();
                                            }                           
                        }else{
                             out.println("Error al editar");                      
                        }
                    }
                }catch(Exception e){
                    System.out.println(""+e);
                    Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, e);
                }
                    break;
                //Listar Ciclos
            case 5:
            try {
                ciclos = listarCiclos();
            } catch (Exception ex) {
                Logger.getLogger(ServiceCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                ciclosJsonString = gson.toJson(ciclos);
                try {
                    out.println(ciclosJsonString);
                } finally {
                    out.close();
                }
                break;
            //Listar Carreras
            case 6:
            try {
                carreras = listarCarreras();
            } catch (Exception ex) {
                Logger.getLogger(ServiceCurso.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                carrerasJsonString = gson.toJson(carreras);
                try {
                    out.println(carrerasJsonString);
                } finally {
                    out.close();
                }
                break;
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public ArrayList getListCursos() throws GlobalException, NoDataException{
        return control.listarCursos();      
    }
    
    public ArrayList listarCiclos() throws GlobalException, NoDataException {
        ArrayList<Ciclo> array;
        array = (ArrayList<Ciclo>) control.listarCiclos();
        return array;
    }

    public ArrayList listarCarreras() throws GlobalException, NoDataException {
        ArrayList<Carrera> array;
        array = (ArrayList<Carrera>) control.listarCarreras();
        return array;
    }
    
    public Carrera buscarCarrera(String id) throws GlobalException, NoDataException {

        return (Carrera) control.buscarCarrera(id);
    }
    
    public Ciclo buscarCiclo(String id) throws GlobalException, NoDataException {

        return (Ciclo)control.buscarCiclo(id);
    }
    
    public boolean ingresarCurso(Curso c) throws Exception{
        try{          
            control.insertarCurso(c);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    }
    
    public boolean modificarCurso(Curso c) throws Exception{
        try{          
            control.modificarCurso(c);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    }
    
    public boolean eliminarCurso(String id) throws Exception{
        try{          
            control.eliminarCurso(id);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
    
    public Curso buscarCurso(List<Curso> cursoList, String cursoCodigo){
        for (Curso curso : cursoList) {
            if (curso.getCodigo().equals(cursoCodigo)) {
                return curso;
            }
        }
        return null;
    }
    
    public List<Curso> buscarCursoCodigo(String cod) throws GlobalException, NoDataException{
        return control.buscarCursoCodigo(cod);
    }
    
    public List<Curso> buscarCursoNombre(String nom) throws GlobalException, NoDataException{
        return control.buscarCursoNombre(nom);
    }

    public List<Curso> buscarCursoCarrera(String carrera) throws GlobalException, NoDataException{
        return control.buscarCursoCarrera(carrera);
    }
    
    public Carrera buscarCarreraPorNombre(String nombre) throws GlobalException, NoDataException{
        return control.buscarCarreraPorNombre(nombre);
    }
}
