package test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

public class AddProductDAO {
int k ; 

public int insert (HttpServletRequest req) {
	try {
		
		Connection con = DBConnection.getCon();
		PreparedStatement ps = con.prepareStatement("insert into imgret55 values (?, ? ,? ,? ,? )" );
		ps.setString(1, req.getParameter("id"));
		ps.setString(2, req.getParameter("name"));
		ps.setDouble(3, Double.parseDouble(req.getParameter("price")));
		ps.setInt(4, Integer.parseInt(req.getParameter("qty") ));
		
		File file  = new File("E:\\movies\\image\\"+req.getParameter("pimg"));
		FileInputStream f = new FileInputStream(file);
		ps.setBlob(5, f);
		
		k = ps.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return k ; 
}



}
