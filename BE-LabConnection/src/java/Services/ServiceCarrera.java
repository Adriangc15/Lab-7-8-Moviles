/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AccesoDatos.GlobalException;
import Control.Control;
import Entidades.Carrera;
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
@WebServlet(name = "ServiceCarrera", urlPatterns = {"/ServiceCarrera"})
public class ServiceCarrera extends HttpServlet {
    
    private Control control = new Control();
    private String carrerasJsonString;
    ArrayList<Carrera> carreras;

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
            //Listar Carreras
            case 1:
            try {
                carreras = getListCarreras();
            } catch (Exception ex) {
                Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                carrerasJsonString = gson.toJson(carreras);
                try {
                    out.println(carrerasJsonString);
                } finally {
                    out.close();
                }
                break;
            //Agregar Carrera
            case 2:
                Carrera c = null;
                try {
                    c = new Carrera();
                    c.setCodigo(req.getParameter("codigo"));
                    c.setNombre(req.getParameter("nombre"));
                    c.setTitulo(req.getParameter("titulo"));
                    
                     if(ingresarCarrera(c)){
                                    try {
                                        carreras = getListCarreras();
                                        } catch (Exception ex) {
                                            Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                            carrerasJsonString = gson.toJson(carreras);
                                            try {
                                                out.println(carrerasJsonString);
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
            //Elimina Carrera
            case 3:
                try {
                    String idEliminar = req.getParameter("codigo");
                if(eliminarCarrera(idEliminar)){
                      out.println("carrera eliminada");
                }else{
                      out.println("error al eliminar");              
                }
                
            }catch(Exception e){
                System.out.println(""+e);
                Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, e);
            }
                break;
            //Editar Carrera
            case 4:
            try{
                String codigoEditar = req.getParameter("codigo");
                String nombreEditar = req.getParameter("nombre");
                carreras = getListCarreras();
                Carrera carreraEditar = null;
                if(nombreEditar == null){
                    if(buscarCarrera(carreras, codigoEditar) != null){
                        carreraEditar = buscarCarrera(carreras, codigoEditar);
                    }
                }else{
                    carreraEditar = new Carrera();
                    carreraEditar.setCodigo(req.getParameter("codigo"));
                    carreraEditar.setNombre(req.getParameter("nombre"));
                    carreraEditar.setTitulo(req.getParameter("titulo"));
                                        
                    if(modificarCarrera(carreraEditar)){
                         try {
                                        carreras = getListCarreras();
                                        } catch (Exception ex) {
                                            Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                            carrerasJsonString = gson.toJson(carreras);
                                            try {
                                                out.println(carrerasJsonString);
                                            } finally {
                                                out.close();
                                            }                           
                        }else{
                             out.println("Error al editar");                      
                        }
                    }
                }catch(Exception e){
                    System.out.println(""+e);
                    Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, e);
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

   public ArrayList<Carrera> getListCarreras() throws Exception{
        try{
            return control.listarCarreras();      
        }catch(GlobalException ex){
            System.out.println(""+ex);
            return null;
        }
    }
    
    public boolean eliminarCarrera(String id) throws Exception{
        try{          
            control.eliminarCarrera(id);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
    
    public boolean ingresarCarrera(Carrera c) throws Exception{
        try{          
            control.insertarCarrera(c);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
    
    public Carrera buscarCarrera(List<Carrera> carreraList, String carreraId){
        for (Carrera carrera : carreraList) {
            if (carrera.getCodigo().equals(carreraId)) {
                return carrera;
            }
        }
        return null;
    }
    
    public boolean modificarCarrera(Carrera c) throws Exception{
        try{          
            control.modificarCarrera(c);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 


}
