package com.mycompany.pocs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;  
        
        
        if(args.length == 0) return;
        
        
        String id = args[0];
        
        
            
        try 
        {

            String safeId = safeString(id);
            
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:sqlite.db");
            statement = conn.createStatement();  
            ResultSet rs = statement.executeQuery(String.format("SELECT * FROM users WHERE id = '%s' LIMIT 1", safeId));
            
            if(rs.next()) System.out.println(rs.getString("name"));

        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
           Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally
        {
            try 
            {
                if (conn != null) conn.close();
            } 
            catch (SQLException ex) 
            {
               Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
    public static String safeString(String str)
    {
        return str.replaceAll("[^a-zA-Z0-9]", "");
    } 
  
}
