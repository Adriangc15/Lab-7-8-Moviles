/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Control.Control;
import AccesoDatos.GlobalException;
import Entidades.Alumno;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author David Guzman
 */
@WebServlet(name = "ServiceAlumno", urlPatterns = {"/ServiceAlumno"})
public class ServiceAlumno extends HttpServlet {
    
    private Control control = new Control();
    private String alumnosJsonString;
    ArrayList<Alumno> alumnos;

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
            //Listar Alumnos
            case 1:
            try {
                alumnos = getListAlumnos();
            } catch (Exception ex) {
                Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                alumnosJsonString = gson.toJson(alumnos);
                try {
                    out.println(alumnosJsonString);
                } finally {
                    out.close();
                }
                break;
            //Agregar Alumno
            case 2:
                Alumno a = null;
                try {
                    a = new Alumno();
                    a.setCedula(req.getParameter("cedula"));
                    a.setNombre(req.getParameter("nombre"));
                    a.setTelefono(Integer.parseInt(req.getParameter("telefono")));
                    a.setEmail(req.getParameter("email"));
//                    String fecha = req.getParameter("fecha");
//                    java.sql.Date sqlDate = Date.valueOf(fecha);
                    a.setFechaNacimiento(req.getParameter("fecha"));
                    
                     if(ingresarAlumno(a)){
                                    try {
                                        alumnos = getListAlumnos();
                                        } catch (Exception ex) {
                                            Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                            alumnosJsonString = gson.toJson(alumnos);
                                            try {
                                                out.println(alumnosJsonString);
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
            //Elimina Alumno
            case 3:
                try {
                    String cedEliminar = req.getParameter("cedula");
                if(eliminarAlumno(cedEliminar)){
                      out.println("alumno eliminado");
                }else{
                      out.println("error al eliminar");              
                }
                
            }catch(Exception e){
                System.out.println(""+e);
                Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, e);
            }
                break;
            case 4:
            try{
                String cedulaEditar = req.getParameter("cedula");
                String nombreEditar = req.getParameter("nombre");
                alumnos = getListAlumnos();
                Alumno alumnoEditar = null;
                if(nombreEditar == null){
                    if(buscarAlumno(alumnos, cedulaEditar) != null){
                        alumnoEditar = buscarAlumno(alumnos, cedulaEditar);
                    }
                }else{
                    alumnoEditar = new Alumno();
                    alumnoEditar.setCedula(req.getParameter("cedula"));
                    alumnoEditar.setNombre(req.getParameter("nombre"));
                    alumnoEditar.setTelefono(Integer.parseInt(req.getParameter("telefono")));
                    alumnoEditar.setEmail(req.getParameter("email"));
//                    String fecha = req.getParameter("fecha");
//                    java.sql.Date sqlDate = Date.valueOf(fecha);
                    alumnoEditar.setFechaNacimiento(req.getParameter("fecha"));
                    
                    
                    if(modificarAlumno(alumnoEditar)){
                         try {
                                        alumnos = getListAlumnos();
                                        } catch (Exception ex) {
                                            Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                            alumnosJsonString = gson.toJson(alumnos);
                                            try {
                                                out.println(alumnosJsonString);
                                            } finally {
                                                out.close();
                                            }                           
                        }else{
                             out.println("Error al editar");                      
                        }
                    }
                }catch(Exception e){
                    System.out.println(""+e);
                    Logger.getLogger(Alumno.class.getName()).log(Level.SEVERE, null, e);
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
    
    public ArrayList<Alumno> getListAlumnos() throws Exception{
        try{
            return control.listarAlumnos();      
        }catch(GlobalException ex){
            System.out.println(""+ex);
            return null;
        }
    }
    
    public boolean eliminarAlumno(String id) throws Exception{
        try{          
            control.eliminarAlumno(id);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
    
    public boolean ingresarAlumno(Alumno a) throws Exception{
        try{          
            control.insertarAlumno(a);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
    
    public Alumno buscarAlumno(List<Alumno> alumnoList, String alumnoCedula){
        for (Alumno alumno : alumnoList) {
            if (alumno.getCedula().equals(alumnoCedula)) {
                return alumno;
            }
        }
        return null;
    }
    
    public boolean modificarAlumno(Alumno a) throws Exception{
        try{          
            control.modificarAlumno(a);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
}
