/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import AccesoDatos.GlobalException;
import AccesoDatos.NoDataException;
import AccesoDatos.Servicio;
import Entidades.Alumno;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import oracle.jdbc.OracleTypes;



/**
 *
 * @author David Guzman
 */
public class ServicioAlumno extends Servicio{
    private static final String INSERTARALUMNO = "{call INSERTARALUMNO(?,?,?,?,?)}";
    private static final String ELIMINARALUMNO = "{call ELIMINARALUMNO(?)}";
    private static final String MODIFICARALUMNO = "{call modificarAlumno(?,?,?,?,?)}";
    private static final String LISTARALUMNOS = "{?=call listarAlumnos()}";
    private static final String BUSCARALUMNO = "{?=call buscarAlumno(?)}";
    
    private static final String BUSCARALUMNONOMBRE = "{?=call buscarAlumnoNombre(?)}";
    private static final String BUSCARALUMNOCEDULA = "{?=call buscarAlumnoCedula(?)}";
    
    public boolean insertarAlumno(Alumno alumno) throws GlobalException  	
    {
        try 
        {
            conectar();
        } 
        catch (ClassNotFoundException e) 
        {
            throw new GlobalException("No se ha localizado el driver.");
        } 
        catch (SQLException e) 
        {
            throw new GlobalException("La base de datos no se encuentra disponible.");
        }
        CallableStatement pstmt=null;
        
        try 
        {
            pstmt = conexion.prepareCall(INSERTARALUMNO);
            pstmt.setString(1,alumno.getCedula());
            pstmt.setString(2,alumno.getNombre());
            pstmt.setInt(3,alumno.getTelefono());
            pstmt.setString(4,alumno.getEmail());
            pstmt.setString(5,alumno.getFechaNacimiento());
            
            boolean resultado = pstmt.execute();
            if (resultado == true) 
            {
                throw new GlobalException("No se pudo insertar el alumno.");
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            throw new GlobalException("Número de identificación duplicado.");
        } 
        finally 
        {
            try 
            {
                if (pstmt != null) 
                {
                    pstmt.close();
                }
                desconectar();
                
            } 
            catch (SQLException e) 
            {
                throw new GlobalException("Error al desconectar.");
            }
            return true;
        }
        
    }
    
    
    public ArrayList listarAlumnos() throws GlobalException  	
    {
        try 
        {
            conectar();
        } 
        catch (ClassNotFoundException e) 
        {
            throw new GlobalException("No se ha localizado el driver.");
        } 
        catch (SQLException e) 
        {
            throw new GlobalException("La base de datos no se encuentra disponible.");
        }
        CallableStatement pstmt=null;
        ResultSet rs = null;
	ArrayList coleccion = new ArrayList();
	Alumno alumno = null;
        try
        {
                pstmt = conexion.prepareCall(LISTARALUMNOS);
                pstmt.registerOutParameter(1, OracleTypes.CURSOR);
                pstmt.execute();
                rs = (ResultSet)pstmt.getObject(1);
                while (rs.next())
                {
                        alumno = new Alumno(rs.getString("cedula"),
                                            rs.getString("nombre"),
                                            rs.getInt("telefono"),
                                            rs.getString("email"),
                                            rs.getString("fecha_nacimiento"));
                        coleccion.add(alumno);
                }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new GlobalException("Error al recuperar datos.\n");
        }
        finally
        {
            try
            {
                if (rs != null)
                {
                    rs.close();
                }
                if (pstmt != null)
                {
                    pstmt.close();
                }
                desconectar();
            }
            catch (SQLException e)
            {
                throw new GlobalException("Estatutos invalidos o nulos.");
            }
        }
        if (coleccion == null || coleccion.isEmpty())
        {
            throw new GlobalException("No hay datos.");
        }
        return coleccion;
        
    }
    
    public boolean eliminarAlumno(String cedula) throws GlobalException  	
    {
        try 
        {
            conectar();
        } 
        catch (ClassNotFoundException e) 
        {
            throw new GlobalException("No se ha localizado el driver.");
        } 
        catch (SQLException e) 
        {
            throw new GlobalException("La base de datos no se encuentra disponible.");
        }
        CallableStatement pstmt=null;
        
        try 
        {
            pstmt = conexion.prepareCall(ELIMINARALUMNO);
            pstmt.setString(1,cedula);
            
            boolean resultado = pstmt.execute();
            if (resultado == true) 
            {
                throw new GlobalException("No se pudo insertar el alumno.");
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            throw new GlobalException("Número de identificación duplicado.");
        } 
        finally 
        {
            try 
            {
                if (pstmt != null) 
                {
                    pstmt.close();
                }
                desconectar();
                
            } 
            catch (SQLException e) 
            {
                throw new GlobalException("Error al desconectar.");
            }
            return true;
        }
        
    }
    
    public boolean editarAlumno(Alumno alumno) throws GlobalException  	
    {
        try 
        {
            conectar();
        } 
        catch (ClassNotFoundException e) 
        {
            throw new GlobalException("No se ha localizado el driver.");
        } 
        catch (SQLException e) 
        {
            throw new GlobalException("La base de datos no se encuentra disponible.");
        }
        CallableStatement pstmt=null;
        
        try 
        {
            pstmt = conexion.prepareCall(MODIFICARALUMNO);
            pstmt.setString(1,alumno.getCedula());
            pstmt.setString(2,alumno.getNombre());
            pstmt.setInt(3,alumno.getTelefono());
            pstmt.setString(4,alumno.getEmail());
            pstmt.setString(5,alumno.getFechaNacimiento());
            
            boolean resultado = pstmt.execute();
            if (resultado == true) 
            {
                throw new GlobalException("No se pudo insertar el alumno.");
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            throw new GlobalException("Número de identificación duplicado.");
        } 
        finally 
        {
            try 
            {
                if (pstmt != null) 
                {
                    pstmt.close();
                }
                desconectar();
                
            } 
            catch (SQLException e) 
            {
                throw new GlobalException("Error al desconectar.");
            }
            return true;
        }
        
    }
    
    public ArrayList buscarAlumno(String cedula)throws GlobalException, NoDataException{
        try {
            conectar();
        } catch(ClassNotFoundException e) {
            throw  new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw  new NoDataException("La base de datos no se encuentra disponible");
        }
        
        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        Alumno elalumno = null;
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(BUSCARALUMNO);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, cedula);
            pstmt.execute();
            rs = (ResultSet)pstmt.getObject(1);
            
            while(rs.next()){
                elalumno = new Alumno(
                        rs.getString("CED_ALUMNO"), 
                        rs.getString("NOMBRE_ALUMNO"), 
                        rs.getInt("TELEFONO"), 
                        rs.getString("EMAIL"),
                        rs.getString("FECHA_NACIMIENTO"));
                coleccion.add(elalumno);
            }
        } catch(SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Sentencia no valida");
        }
        finally {
            try{
                if(rs != null){
                    rs.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
            }catch(SQLException e){
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if(coleccion == null || coleccion.size()==0){
            throw new NoDataException("No hay datos");        
        }
        return coleccion;
    }

    public ArrayList buscarAlumnoCedula(String cedula) throws GlobalException, NoDataException{

		try{
			conectar();
		}catch (ClassNotFoundException e){
			throw new GlobalException("No se ha localizado el driver");
		}
		catch (SQLException e){
			throw new NoDataException("La base de datos no se encuentra disponible");
		}
		ResultSet rs = null;
		ArrayList coleccion = new ArrayList();
                Alumno alumno = null;    
		//Ciclo elciclo = null;
		CallableStatement pstmt = null;
		try{
			pstmt = conexion.prepareCall(BUSCARALUMNOCEDULA);
			pstmt.registerOutParameter(1, OracleTypes.CURSOR);
			pstmt.setString(2, cedula);
			pstmt.execute();
			rs = (ResultSet)pstmt.getObject(1);
			while (rs.next()){
                            alumno = new Alumno(
                                    rs.getString("CEDULA"), 
                                    rs.getString("NOMBRE"), 
                                    rs.getInt("TELEFONO"), 
                                    rs.getString("EMAIL"),
                                    rs.getString("FECHA_NACIMIENTO"));
                            coleccion.add(alumno);
			}
		}
		catch (SQLException e){
			e.printStackTrace();

			throw new GlobalException("Sentencia no valida");
		}
		finally{
			try{
				if (rs != null){
					rs.close();
				}
				if (pstmt != null){
					pstmt.close();
				}
				desconectar();
			}
			catch (SQLException e){
				throw new GlobalException("Estatutos invalidos o nulos");
			}
		}
		if (coleccion == null || coleccion.size() == 0){
			throw new NoDataException("No hay datos");
		}
		return coleccion;
	}
    
     public ArrayList buscarAlumnoNombre(String nombre) throws GlobalException, NoDataException{

		try{
			conectar();
		}catch (ClassNotFoundException e){
			throw new GlobalException("No se ha localizado el driver");
		}
		catch (SQLException e){
			throw new NoDataException("La base de datos no se encuentra disponible");
		}
		ResultSet rs = null;
		ArrayList coleccion = new ArrayList();
                Alumno alumno = null;    
		//Ciclo elciclo = null;
		CallableStatement pstmt = null;
		try{
			pstmt = conexion.prepareCall(BUSCARALUMNONOMBRE);
			pstmt.registerOutParameter(1, OracleTypes.CURSOR);
			pstmt.setString(2, nombre);
			pstmt.execute();
			rs = (ResultSet)pstmt.getObject(1);
			while (rs.next()){
                            alumno = new Alumno(
                                    rs.getString("CEDULA"), 
                                    rs.getString("NOMBRE"), 
                                    rs.getInt("TELEFONO"), 
                                    rs.getString("EMAIL"),
                                    rs.getString("FECHA_NACIMIENTO"));
                            coleccion.add(alumno);
			}
		}
		catch (SQLException e){
			e.printStackTrace();

			throw new GlobalException("Sentencia no valida");
		}
		finally{
			try{
				if (rs != null){
					rs.close();
				}
				if (pstmt != null){
					pstmt.close();
				}
				desconectar();
			}
			catch (SQLException e){
				throw new GlobalException("Estatutos invalidos o nulos");
			}
		}
		if (coleccion == null || coleccion.size() == 0){
			throw new NoDataException("No hay datos");
		}
		return coleccion;
	}
          
    public boolean insertarAlumno_(Alumno alumno) throws GlobalException  	
    {
        try 
        {
            conectar();
        } 
        catch (ClassNotFoundException e) 
        {
            throw new GlobalException("No se ha localizado el driver.");
        } 
        catch (SQLException e) 
        {
            throw new GlobalException("La base de datos no se encuentra disponible.");
        }
        CallableStatement pstmt=null;
        
        try 
        {
            pstmt = conexion.prepareCall(INSERTARALUMNO);
            pstmt.setString(1,alumno.getCedula());
            pstmt.setString(2,alumno.getNombre());
            pstmt.setInt(3,alumno.getTelefono());
            pstmt.setString(4,alumno.getEmail());
            pstmt.setString(5,alumno.getFechaNacimiento());
            
            boolean resultado = pstmt.execute();
            if (resultado == true) 
            {
                throw new GlobalException("No se pudo insertar el alumno.");
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            throw new GlobalException("Número de identificación duplicado.");
        } 
        finally 
        {
            try 
            {
                if (pstmt != null) 
                {
                    pstmt.close();
                }
                desconectar();
                
            } 
            catch (SQLException e) 
            {
                throw new GlobalException("Error al desconectar.");
            }
            return true;
        }
        
    }
}
