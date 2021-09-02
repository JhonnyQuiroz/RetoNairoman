/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonny
 */
public class DataBase {
    
    public String nameDB="nairoman";
    public String url="jdbc:mysql://localhost/"+ nameDB;
    public String user="root";
    public String pass="";

    public DataBase() {
        
    }
    
    public Connection Connectar(){
    
        Connection link= null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            link=(Connection) DriverManager.getConnection(url,user,pass);
            
                    
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "No funca");
        }
        return link;
    }
    
    
}
