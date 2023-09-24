package test;
import static test.DBInfo.*;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	
	public static Connection con ; 
	
	private DBConnection() {
		
	}
	
	static {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dburl, user, pword);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public static Connection getCon() {
		return con;
	}
	
	
	

}
