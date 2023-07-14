/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import  java.sql.*;
import javax.swing.JOptionPane;

public class DBConexion {
    
    public static Connection Conexion()
    {
     
       Connection con = null;
       
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/estudiantesfica","root","");
            
            if (con != null) {
                JOptionPane.showMessageDialog(null, "Conexion exitosa");            
            }
            
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return con;
    }  
}
