/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.assignment.baraka;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.github.cdimascio.dotenv.Dotenv;
public class Database {
     static Dotenv  dotenv = Dotenv.load();
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
     static final String DB_URL = "jdbc:mysql://localhost/mwanzoGroup";
      
      static final String USER = dotenv.get("DB_USER");
      static final String PASS = dotenv.get("DB_PASS");
      static Connection conn = null;

    
    public  static  Connection mycon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to Database successfully");
            
        }catch(Exception e){
            e.printStackTrace();
        } 
        return conn;
    }

    
   
    
}
