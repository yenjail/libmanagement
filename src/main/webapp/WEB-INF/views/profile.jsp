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
	Welcome: <%= session.getAttribute("activeUser") %> |
	<a href="${pageContext.request.contextPath}/logout "> Logout User</a>
	<br/>
	<hr/>
	<a href="${pageContext.request.contextPath}/readerReg " >Register a new Reader</a> | &nbsp;
	<a href="${pageContext.request.contextPath}/documentReg ">Document record</a> | &nbsp;
	<a href="${pageContext.request.contextPath}/borrowDoc">Borrow a document</a> | &nbsp;
	<a href="${pageContext.request.contextPath}/reserveReq">Reserve Request</a> | &nbsp;
	<a href="${pageContext.request.contextPath}/reservedList">Reserved List</a> | &nbsp;
	<a href="${pageContext.request.contextPath}/uploadCheck">Upload Check</a> | &nbsp;
	<a></a>
</body>
</html>