/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Antony Sanchez
 */
public class Consultas_carreras extends Conexion{
    
    public boolean Registrar(Carreras pro){
        PreparedStatement ps=null;
        Connection con=(Connection) getconexion();
        
        String sql="INSERT INTO carreras(id_carrera,nombre,capacidad_asistentes,nivel_dificultad,bajo_techo)"
                + "VALUES(?,?,?,?,?)";
        
        try{
            ps= (PreparedStatement) con.prepareStatement(sql);   
            ps.setInt(1,pro.getId_carrera());
            ps.setString(2,pro.getNombre());
            ps.setDouble(3,pro.getCapacidad_asistentes());
            ps.setDouble(4,pro.getNivel_dificultad());
            ps.setBoolean(5,pro.isBajo_techo());
            
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
    public boolean modificar(Carreras pro){
        PreparedStatement ps=null;
        Connection con=(Connection) getconexion();
        
        String sql="UPDATE carreras SET nombre=?,capacidad_asistentes=?,nivel_dificultad=?,bajo_techo=? WHERE id_carrera=?";
        
        try{
            ps=(PreparedStatement) con.prepareStatement(sql);   
            
            ps.setString(1,pro.getNombre());
            ps.setDouble(2,pro.getCapacidad_asistentes());
            ps.setDouble(3,pro.getNivel_dificultad());
            ps.setBoolean(4,pro.isBajo_techo());
            ps.setInt(5,pro.getId_carrera());
            //Le cambie la posicion a los argumentos en base a la consulta 
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        
    }
    public boolean eliminar(Carreras pro){
        PreparedStatement ps=null;
        Connection con=(Connection) getconexion();
        
        String sql="DELETE FROM carreras WHERE id_carrera=?";
        
        try{
            ps=(PreparedStatement) con.prepareStatement(sql);   
            ps.setInt(1,pro.getId_carrera());
            
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        
    }
    public boolean buscar(Carreras pro){
        PreparedStatement ps=null;
        ResultSet rs=null;
        Connection con=(Connection) getconexion();
        
        String sql="SELECT * FROM carreras WHERE id_carrera=?";
        
        try{
            ps=(PreparedStatement) con.prepareStatement(sql);   
            ps.setInt(1,pro.getId_carrera());
            rs=ps.executeQuery();
            
            if(rs.next()){
                pro.setId_carrera((Integer.parseInt(rs.getString("id_carrera"))));
                pro.setNombre(rs.getString("nombre"));
                pro.setCapacidad_asistentes(Double.parseDouble(rs.getString("capacidad_asistentes")));
                pro.setNivel_dificultad(Double.parseDouble(rs.getString("nivel_dificultad")));
                pro.setBajo_techo(Boolean.parseBoolean(rs.getString("bajo_techo")));
                
                return true;
            }
            return false;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
}
