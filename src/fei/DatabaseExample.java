/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fei;

import java.io.BufferedReader;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author feilu
 */
public class DatabaseExample {
    
    public DatabaseExample () {
        
        this.connectToMySQL();
    }
    
    public void test () {
        
    }
    
    public void connectToSQLite () {
        String dbFileS = null;
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+dbFileS;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM runoob_tbl");
            
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    public void connectToMySQL() {
        String username = "root";
        String password = "MySQLPass1!@#";
        String url = "jdbc:mysql://localhost:3306/runoob";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM runoob_tbl");
            while (rs.next()) {
                int id = rs.getInt("runoob_id");
                String title = rs.getNString("runoob_title");
                System.out.println(title);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
