package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
	
	static Connection conn ;
	static PreparedStatement ps;
	static ResultSet rs;
	
	//connects to database
	 public static Connection connect() {
	       
	        try {
	          
	            String url = "jdbc:sqlite:my_db.db";
	            conn = DriverManager.getConnection(url);
	            System.out.println("Connection to SQLite has been established.");
	            return conn;
	            
	        } catch (SQLException e) {
	        	e.printStackTrace();
	            return conn;
	        } 
	    }
	 
	 //gets data from database
	 
	
}
