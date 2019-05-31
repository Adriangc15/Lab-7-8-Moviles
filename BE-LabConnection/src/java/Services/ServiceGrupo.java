/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import Control.Control;
import Entidades.Curso;
import Entidades.Grupo;
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
@WebServlet(name = "ServiceGrupo", urlPatterns = {"/ServiceGrupo"})
public class ServiceGrupo extends HttpServlet {
    
    private Control control = new Control();
    ArrayList<Grupo> grupos;
    private String gruposJsonString;
    ArrayList<Curso> cursos;
    private String cursosJsonString;
    ArrayList<Profesor> profesores;   
    private String profesoresJsonString;

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
            //Listar Grupos
            case 1:
            try {
                grupos = getListGrupos();
            } catch (Exception ex) {
                Logger.getLogger(ServiceGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                gruposJsonString = gson.toJson(grupos);
                try {
                    out.println(gruposJsonString);
                } finally {
                    out.close();
                }
                break;
            //Agregar Grupo
            case 2:
                
                Grupo g = new Grupo();
                try {
                        g = new Grupo();
                        g.setCodigo(req.getParameter("codigo"));
                        g.setCurso(buscarCurso(req.getParameter("curso")));
                        g.setProfesor(buscarProfesor(req.getParameter("profesor")));                   
                        g.setHorario(req.getParameter("horario"));
                    
                     if(ingresarGrupo(g)){
                                    try {
                                        grupos = getListGrupos();
                                        } catch (Exception ex) {
                                            Logger.getLogger(ServiceGrupo.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                            gruposJsonString = gson.toJson(grupos);
                                            try {
                                                out.println(grupos);
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
            //Elimina Grupo
            case 3:
                try {
                    String codEliminar = req.getParameter("codigo");
                if(eliminarGrupo(codEliminar)){
                      out.println("grupo eliminado");
                }else{
                      out.println("error al eliminar");              
                }
                
            }catch(Exception e){
                System.out.println(""+e);
                Logger.getLogger(Curso.class.getName()).log(Level.SEVERE, null, e);
            }
                break;
            //Edita Grupo
            case 4:
            try{
                String codigoEditar = req.getParameter("codigo");
                String horarioEditar = req.getParameter("horario"); 
                
                grupos = getListGrupos();
                Grupo grupoEditar = null;
                if(horarioEditar == null){
                    if(buscarGrupo(grupos, codigoEditar) != null){
                        grupoEditar = buscarGrupo(grupos, codigoEditar);
                    }
                }else{
                    grupoEditar = new Grupo();
                    grupoEditar.setCodigo(req.getParameter("codigo"));
                    grupoEditar.setCurso(buscarCurso(req.getParameter("curso")));
                    grupoEditar.setProfesor(buscarProfesor(req.getParameter("profesor")));                   
                    grupoEditar.setHorario(req.getParameter("horario"));
                    
                    if(modificarGrupo(grupoEditar)){
                         try {
                                        grupos = getListGrupos();
                                        } catch (Exception ex) {
                                            Logger.getLogger(ServiceGrupo.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                            gruposJsonString = gson.toJson(grupos);
                                            try {
                                                out.println(gruposJsonString);
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
            case 5:
            try {
                cursos = getListCursos();
            } catch (Exception ex) {
                Logger.getLogger(ServiceGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                cursosJsonString = gson.toJson(cursos);
                try {
                    out.println(cursosJsonString);
                } finally {
                    out.close();
                }
                break;
            case 6:
            try {
                profesores = getListProfesores();
            } catch (Exception ex) {
                Logger.getLogger(ServiceGrupo.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                profesoresJsonString = gson.toJson(profesores);
                try {
                    out.println(profesoresJsonString);
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
    
    public ArrayList getListGrupos() throws GlobalException, NoDataException{
        return control.listarGrupos();
    }
    
    public ArrayList getListCursos() throws Exception{
        try{
            return control.listarCursos();      
        }catch(GlobalException ex){
            System.out.println(""+ex);
            return null;
        }
    }
        
    public ArrayList getListProfesores() throws Exception{
        return control.listaProfesores();
    }
    
    public boolean eliminarGrupo(String codigo) throws Exception{
        try{          
            control.eliminarGrupo(codigo);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
    
    public boolean ingresarGrupo(Grupo a) throws Exception{
        try{          
            control.ingresarGrupo(a);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
    
    public boolean modificarGrupo(Grupo g) throws Exception{
        try{          
            control.modificarGrupo(g);    
            return true;
        }
        catch(GlobalException | SQLException ex){
            return false;
        }
    } 
    
    public Grupo buscarGrupo(List<Grupo> alumnoList, String codigo){
        for (Grupo grupo : alumnoList) {
            if (grupo.getCodigo().equals(codigo)) {
                return grupo;
            }
        }
        return null;
    }
    
    public Curso buscarCurso(String id) throws GlobalException, NoDataException {

        return (Curso)control.buscarCurso(id);
    }
    
    public Profesor buscarProfesor(String id) throws GlobalException, NoDataException {

        return (Profesor)control.buscarProfesor(id);
    }
    
    public ArrayList listarCursos() throws GlobalException, NoDataException {
        ArrayList<Curso> array;
        array = (ArrayList<Curso>) control.listarCursos();
        return array;
    }
    
    public ArrayList listarProfesores() throws GlobalException, NoDataException {
        ArrayList<Profesor> array;
        array = (ArrayList<Profesor>) control.listaProfesores();
        return array;
    }

}
