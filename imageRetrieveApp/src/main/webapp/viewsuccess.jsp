<%@page import="java.util.Iterator"%>
<%@page import="test.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
ArrayList<ProductBean> pbs =  (ArrayList<ProductBean>) request.getAttribute("pblist");   
Iterator<ProductBean> it = pbs.iterator();
while(it.hasNext()){
	ProductBean pb = it.next();
	out.println("<div style='display:inline-block; margin:20px ;'> "
	+"<div style='width:100px; height:100px; border:2px solid black;'>"
	+" <img src ='data:image;base64,"+
	pb.getImgpath()+"' alt ='no image ' width= 100px height = 100px> </div><br> <h2> Product Id : "+pb.getId()+" </h2> <br> "+
	"<h2> Product Name : "+pb.getName()+" </h2> <br> "+
	"<h2> Product Price : "+pb.getPrice()+" </h2> <br> "+
	"<h2> Product Quantity : "+pb.getQty()+" </h2> <br> "+

	"</div>");
}
%>

</body>
</html>