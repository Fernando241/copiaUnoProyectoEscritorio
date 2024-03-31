
package modelo;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Conexion {
    private String base = "tienda1";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql//localhost:3306/"+base;
    private Connection con = null;
    
public Connection getConnection(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection) DriverManager.getConnection(this.url,this.user,this.password);
        JOptionPane.showMessageDialog(null, "Conexión Establecida");
    } catch (SQLException e){
        System.err.println(e);
        JOptionPane.showMessageDialog(null, "Error");
    } catch (ClassNotFoundException ex){
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
    }
    return con;
    
}
}
