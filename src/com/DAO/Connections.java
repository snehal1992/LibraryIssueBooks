package com.DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;


public class Connections{

public Connection getConnection() throws SQLException {

	Connection conn=null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
        
    System.out.println("Connected to database");
}
    catch (Exception e) {
		e.printStackTrace();
	}
    System.out.println("Connected to database empty");
    return conn;
}
}