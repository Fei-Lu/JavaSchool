/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fei;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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