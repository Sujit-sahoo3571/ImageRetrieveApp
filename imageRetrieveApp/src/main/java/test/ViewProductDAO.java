package test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;

public class ViewProductDAO {
	
	ArrayList<ProductBean> pblist = new ArrayList<>();
	
	
	public ArrayList<ProductBean> viewProduct(){
		
		
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps= con.prepareStatement("select * from imgret55");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductBean pb = new ProductBean();
				pb.setId(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getDouble(3));
				pb.setQty(rs.getInt(4));
				pb.setImgpath(rs.getBlob(5).toString());
				
				
				//img
				// input stream hold the binary data of image
//				InputStream is = rs.getBinaryStream(5);
//				// byte array object created to write
//				ByteArrayOutputStream bos = new ByteArrayOutputStream();
//				// img arry byte 
//				byte [] img = new byte[5000];
//				// cursor postion 
//				int bread = -1; 
//				while( (bread =is.read(img)) != -1  ) {
//					// write in byte array output stream
//					bos.write(img, 0, bread);
//					
//				}
//				// store byte array data in byte array
//				byte [] image  = bos.toByteArray();
//				// convert the byte data to base64 encoder to string
//				String base64image = Base64.getEncoder().encodeToString(image);
//				//set path in string
//				pb.setImgpath(base64image);
//				System.out.println(pb);
//				System.out.println(base64image);
//				
				//image 
				
				
				 InputStream is  = rs.getBinaryStream(5);
					ByteArrayOutputStream  bis = new ByteArrayOutputStream();
					byte [] img = new byte[5000];
					int byteRead = -1;
					while((byteRead = is.read(img))!=-1)
					{
						bis.write(img, 0, byteRead);
					}
					byte image [] = bis.toByteArray();
//					Base64.getEncoder();
					String imgBase64 = Base64.getEncoder().encodeToString(image);
					pb.setImgpath(imgBase64);
				
				
				
				pblist.add(pb);
				
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return pblist; 
		
	}
	

}
