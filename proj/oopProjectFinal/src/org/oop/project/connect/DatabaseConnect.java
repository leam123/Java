package org.oop.project.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Garcia
 */
public class DatabaseConnect {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
    //Database credentials
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    
    public Connection getConnection(){
       Connection connect = null;
       try{
           //create connection
           Class.forName(DRIVER);
           connect = DriverManager.getConnection(URL,USERNAME,PASSWORD);
           return connect;
       }catch(SQLException | ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null,"Disconnected");
           return null;
       }
   }
}
