<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<%
	System.out.print("Checking user");
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/springdb", "root", "");
		PreparedStatement ps = con.prepareStatement("SELECT * FROM reader WHERE " +
		"username = ?");
		ps.setString(1, request.getParameter("username"));
		ResultSet res = ps.executeQuery();
		
		if(res.first()){
			out.print("User name already taken");
		}else {
			out.print("User name is valid");
		}
		
	}catch(Exception e){
		System.out.println(e);
	}



%>
