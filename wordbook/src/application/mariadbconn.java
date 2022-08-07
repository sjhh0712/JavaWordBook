package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mariadbconn{
	PreparedStatement ps;
	ResultSet rs;
	static Connection con = null;
	
	public static Connection mdbcon() {
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/wordbook",
	                "root",
	                "tls7156447");
			System.out.println("connect success");
			return con;
			
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}
