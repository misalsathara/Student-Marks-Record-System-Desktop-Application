/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarksDatabaseConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SD2023
 */
public class DBConnection {
    Connection con;
//    String url="jdbc:mysql://localhost:3306/software_developer_database";
//    String userName="root";
//    String password="";
    
    String url="jdbc:mysql://nvtibaddegama.tech:3306/nvtibad1_MarksDatabaseConnect";
    String userName="nvtibad1_Misal";
    String password="misalsathsara123";
    
    public void MyCon(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url, userName, password);
            System.out.println("My Database Connection is Ok");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



