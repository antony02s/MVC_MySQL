
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private final String base="formula_tapitas";
    private final String user="root";
    private final String passwor="paloma1234";
    private final String url="jdbc:mysql://localhost:3307/"+base;
    
    private Connection con=null;
    public Connection getconexion(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(this.url,this.user,this.passwor);
        }catch(SQLException e){
            System.out.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
