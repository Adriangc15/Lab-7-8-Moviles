/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AccesoDatos.GlobalException;
import Control.Control;
import Entidades.Profesor;
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
@WebServlet(name = "ServiceProfesor", urlPatterns = {"/ServiceProfesor"})
public class ServiceProfesor extends HttpServlet {
    
    private Control control = new Control();
    private String profesoresJsonString;
    ArrayList<Profesor> profesores;

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
            //Listar Profesores
            case 1:
            try {
                profesores = getListProfesores();
            } catch (Exception ex) {
                Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                profesoresJsonString = gson.toJson(profesores);
                try {
                    out.println(profesoresJsonString);
                } finally {
                    out.close();
                }
                break;
            //Agregar Profesor
            case 2:
                Profesor p = null;
                try {
                    p = new Profesor();
                    p.setCedula(req.getParameter("cedula"));
                    p.setNombre(req.getParameter("nombre"));
                    p.setTelefono(Integer.parseInt(req.getParameter("telefono")));
                    p.setEmail(req.getParameter("email"));
                    
                     if(ingresarProfesor(p)){
                                    try {
                                        profesores = getListProfesores();
                                        } catch (Exception ex) {
                                            Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                            profesoresJsonString = gson.toJson(profesores);
                                            try {
                                                out.println(profesoresJsonString);
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
            //Elimina Profesor
            case 3:
                try {
                    String cedEliminar = req.getParameter("cedula");
                if(eliminarProfesor(cedEliminar)){
                      out.println("profesor eliminado");
                }else{
                      out.println("error al eliminar");              
                }
                
            }catch(Exception e){
                System.out.println(""+e);
                Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, e);
            }
                break;
            case 4:
            try{
                String cedulaEditar = req.getParameter("cedula");
                String nombreEditar = req.getParameter("nombre");
                profesores = getListProfesores();
                Profesor profesorEditar = null;
                if(nombreEditar == null){
                    if(buscarProfesor(profesores, cedulaEditar) != null){
                        profesorEditar = buscarProfesor(profesores, cedulaEditar);
                    }
                }else{
                    profesorEditar = new Profesor();
                    profesorEditar.setCedula(req.getParameter("cedula"));
                    profesorEditar.setNombre(req.getParameter("nombre"));
                    profesorEditar.setTelefono(Integer.parseInt(req.getParameter("telefono")));
                    profesorEditar.setEmail(req.getParameter("email"));
                    
                    if(modificarProfesor(profesorEditar)){
                         try {
                                        profesores = getListProfesores();
                                        } catch (Exception ex) {
                                            Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                            profesoresJsonString = gson.toJson(profesores);
                                            try {
                                                out.println(profesoresJsonString);
                                            } finally {
                                                out.close();
                                            }                           
                        }else{
                             out.println("Error al editar");                      
                        }
                    }
                }catch(Exception e){
                    System.out.println(""+e);
                    Logger.getLogger(Profesor.class.getName()).log(Level.SEVERE, null, e);
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
    
    public ArrayList<Profesor> getListProfesores() throws Exception{
        try{
            return control.listaProfesores();      
        }catch(GlobalException ex){
            System.out.println(""+ex);
            return null;
        }
    }
    
    public boolean eliminarProfesor(String id) throws Exception{
        try{          
            control.eliminarProfesor(id);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
    
    public boolean ingresarProfesor(Profesor p) throws Exception{
        try{          
            control.insertarProfesor(p);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
    
    public Profesor buscarProfesor(List<Profesor> profesorList, String profesorCedula){
        for (Profesor profesor : profesorList) {
            if (profesor.getCedula().equals(profesorCedula)) {
                return profesor;
            }
        }
        return null;
    }
    
    public boolean modificarProfesor(Profesor p) throws Exception{
        try{          
            control.editarProfesor(p);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
}
