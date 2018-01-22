<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css">
<title>Insert title here</title>
</head>
<body>
	Welcome:
	<%=session.getAttribute("activeReader")%> |
	<a href="${pageContext.request.contextPath}/logout ">Log Out</a>
	<br/>
	<hr/>
	<a href="${pageContext.request.contextPath}/docCheck">Document Reserve</a>


</body>
</html>