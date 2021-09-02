/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Conection.DataBase;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonny
 */
public class Controller {
    
    DataBase mysql= new DataBase();
    Connection cn=mysql.Connectar();

    public boolean iniciarSesion(String email, String password)
    {
        String capture="";
       
        String sql="SELECT * FROM usuarios WHERE correo ='"+email+"' AND contraseña='"+password+"'";
        
        try {
            Statement st= (Statement) cn.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(sql);
            
            while(rs.next()){
                capture=rs.getString("nombre");
                System.out.println(capture);
            }
            if(capture.equals(""))
            {
                return false;
            }else{
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public boolean revisarCorreo(String email) {
        String capture="";
       
        String sql="SELECT * FROM usuarios WHERE correo ='"+email+"'";
        
        try {
            Statement st= (Statement) cn.createStatement();
            ResultSet rs = (ResultSet) st.executeQuery(sql);
            
            while(rs.next()){
                capture=rs.getString("correo");
            }
            if(capture.equals(""))
            {
                return false;//no existe
            }else{
                return true;//existe
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
        
    }

    public boolean crearCuenta(String email, String password, String name) {
        if (!revisarCorreo(email))
        {
            String capture="";
       
        String sql="INSERT INTO usuarios (`nombre`, `correo`, `contraseña`) VALUES ('"+name+"', '"+email+"', '"+password+"')";
        
        try {
            Statement st= (Statement) cn.createStatement();
            st.executeUpdate(sql);
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
        }else
        {
            return false;
        }
    }
        
    

}
