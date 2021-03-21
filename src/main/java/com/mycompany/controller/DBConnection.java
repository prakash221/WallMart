/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Controller;

/**
 *
 * @author dcdip
 */
@Controller
public class DBConnection {

    private Connection conn;
    private Statement st;
    private ResultSet rs;
    private String classname = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localHost:3306/wallmart_db";
    private String dbuser = "root";
    private String dbpass = "";

    public DBConnection() {
        try {
            Class.forName(classname);
            conn = DriverManager.getConnection(url, dbuser, dbpass);
            System.out.println("Database Connected Successfully");
        } catch (ClassNotFoundException ex) {
            System.out.println("Please include drive file");
        } catch (SQLException ex) {
            System.out.println("Can't connect to database");
        }
        
        
    }
    public ResultSet select(String sql) {
        try {
            st = conn.createStatement();
            return st.executeQuery(sql);
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean iud(String sql) {
        try {
            st = conn.createStatement();
            int r = st.executeUpdate(sql);
            return r > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public Connection getConnection()
    {
        return conn;
    }
}
