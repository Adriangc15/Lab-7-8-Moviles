/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AccesoDatos.GlobalException;
import Control.Control;
import Entidades.Ciclo;
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
@WebServlet(name = "ServiceCiclo", urlPatterns = {"/ServiceCiclo"})
public class ServiceCiclo extends HttpServlet {
    
    private Control control = new Control();
    private String ciclosJsonString;
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
            //Listar Ciclos
            case 1:
            try {
                ciclos = getListCiclos();
            } catch (Exception ex) {
                Logger.getLogger(ServiceCiclo.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                ciclosJsonString = gson.toJson(ciclos);
                try {
                    out.println(ciclosJsonString);
                } finally {
                    out.close();
                }
                break;
            //Agregar Ciclo
            case 2:
                Ciclo c = null;
                try {
                        c = new Ciclo();
                        c.setCodigo(req.getParameter("codigo"));
                        c.setFecha_inicio(req.getParameter("f_inicio"));
                        c.setNumero(req.getParameter("numero").charAt(0));                            
                        c.setFecha_finalizacion(req.getParameter("f_final"));
                        c.setEstado(req.getParameter("estado").charAt(0));
                        c.setAno(req.getParameter("ano"));
                    
                     if(ingresarCiclo(c)){
                                    try {
                                        ciclos = getListCiclos();
                                        } catch (Exception ex) {
                                            Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                            ciclosJsonString = gson.toJson(ciclos);
                                            try {
                                                out.println(ciclosJsonString);
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
            //Elimina Ciclo
            case 3:
                try {
                    String idEliminar = req.getParameter("codigo");
                if(eliminarCiclo(idEliminar)){
                      out.println("ciclo eliminado");
                }else{
                      out.println("error al eliminar");              
                }
                
            }catch(Exception e){
                System.out.println(""+e);
                Logger.getLogger(Ciclo.class.getName()).log(Level.SEVERE, null, e);
            }
                break;
            //Edita Ciclo
            case 4:
            try{
                String codigoEditar = req.getParameter("codigo");
                String anoEditar = req.getParameter("ano");
                ciclos = getListCiclos();
                Ciclo cicloEditar = null;
                if(anoEditar == null){
                    if(buscarCiclo(ciclos, codigoEditar) != null){
                        cicloEditar = buscarCiclo(ciclos, codigoEditar);
                    }
                }else{
                        cicloEditar = new Ciclo();
                        cicloEditar.setCodigo(req.getParameter("codigo"));
                        cicloEditar.setFecha_inicio(req.getParameter("f_inicio"));
                        cicloEditar.setNumero(req.getParameter("numero").charAt(0));                            
                        cicloEditar.setFecha_finalizacion(req.getParameter("f_final"));
                        cicloEditar.setEstado(req.getParameter("estado").charAt(0));
                        cicloEditar.setAno(req.getParameter("ano"));
                    
                    
                    if(modificarCiclo(cicloEditar)){
                         try {
                                        ciclos = getListCiclos();
                                        } catch (Exception ex) {
                                            Logger.getLogger(ServiceAlumno.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                            ciclosJsonString = gson.toJson(ciclos);
                                            try {
                                                out.println(ciclosJsonString);
                                            } finally {
                                                out.close();
                                            }                           
                        }else{
                             out.println("Error al editar");                      
                        }
                    }
                }catch(Exception e){
                    System.out.println(""+e);
                    Logger.getLogger(Ciclo.class.getName()).log(Level.SEVERE, null, e);
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

    public ArrayList<Ciclo> getListCiclos() throws Exception{
        try{
            return control.listarCiclos();      
        }catch(GlobalException ex){
            System.out.println(""+ex);
            return null;
        }
    }
    
    public boolean eliminarCiclo(String id) throws Exception{
        try{          
            control.eliminarCiclo(id);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
    
    public boolean ingresarCiclo(Ciclo c) throws Exception{
        try{          
            control.insertarCiclo(c);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
    
    public Ciclo buscarCiclo(List<Ciclo> cicloList, String cicloId){
        for (Ciclo ciclo : cicloList) {
            if (ciclo.getCodigo().equals(cicloId)) {
                return ciclo;
            }
        }
        return null;
    }
    
    public boolean modificarCiclo(Ciclo c) throws Exception{
        try{          
            control.modificarCiclo(c);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
}
