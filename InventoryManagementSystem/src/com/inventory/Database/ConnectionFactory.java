package com.inventory.Database;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

//Clase para verificar y conectar a la base de datos

public class ConnectionFactory {

    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/inventory";
    static String username = "root";
    static String password = "root";

    Properties prop;

    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;

    public ConnectionFactory(){
        /*try 
        {
            //Username y  Password guardados en un xml para no recompilar.
            prop = new Properties();
            prop.loadFromXML(new FileInputStream("lib/DBCredentials.xml"));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        */
        
        try 
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public Connection getConn() 
    {
        try 
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado exitosamente!");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return conn;
    }

    //Método verificacion login
    public boolean checkLogin(String username, String password, String userType)
    {
        String query = "SELECT * FROM users WHERE username='"
                + username
                + "' AND password='"
                + password
                + "' AND usertype='"
                + userType
                + "' LIMIT 1";
        
        //Manejo de excepciones
        try
        {
            resultSet = statement.executeQuery(query);
            if(resultSet.next())
            {
                return true;
            }
        }     
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
}
