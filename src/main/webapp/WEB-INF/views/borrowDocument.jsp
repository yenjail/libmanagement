<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css">

<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="http://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script
	type="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

<script>
$(document).ready(function(){
			$("#documentList").DataTable();
		});
	
$(document).ready(function(){
	$("#readerList").DataTable();
});

$(document).ready(function(){
	$("#transactionList").DataTable();
});
		
		
	</script>
</head>
<body>
	<h2>Borrow a document</h2>
	<div class="alert alert-danger" role="alert"> ${borrowError}  </div>
	<form:form method="POST" modelAttribute="documentBorrow" enctype="multipart/form-data">
		<table>
		<tr>
		<td><form:label path="doc_code">Doc Id: </form:label></td>
		<td><form:input path="doc_code" /> </td>
		
		
		</tr>
	
		<tr>
		<td><form:label path="reader_id">Reader Id: </form:label></td>
		<td><form:input path="reader_id" /> </td>
		</tr>
		
		
		<tr>
				
	<td colspan="2"><input class="btn btn-info" type="submit" value="Loan" /></td>
		</tr>
		</table>
		
		<form:hidden path="transId" />
		
	</form:form>
	
	
	
	
	
	<br /> Document list:
	<table id="documentList" border="1" style="border-collapse: collapse;">
		<thead>
			<tr>
				<th>Document Id</th>
				<th>Document Name</th>
				<th>Original Version</th>
				<th>Digital Version</th>
				<th>Genre</th>
				<th>Author</th>
				<th>Summary</th>
				

			</tr>
		</thead>

		<tbody>
			<c:forEach var="row" items="${documentList}">

				<tr>
					
					<td>${row.doc_code }</td>
					<td>${row.doc_name}</td>
					<td>${row.original_version}</td>
					<td>${row.digital_version}</td>
					<td>${row.genre}</td>
					<td>${row.author}</td>
					<td>${row.summary}</td>
					
				</tr>

			</c:forEach>
		</tbody>


	</table>
	
	
	<hr />

	Reader list:
	<br />
	<table id="readerList" border="1" style="border-collapse: collapse;">
		<thead>
			<tr>
				<th>Reader Id:</th>
				<th>User Name:</th>
				<th>First Name:</th>
				<th>Last Name:</th>
				<th>Contact Number:</th>
				<th>Email Address:</th>
				<th>Password:</th>
				<th>Photo Name:</th>
				

			</tr>
		</thead>

		<tbody>
			<c:forEach var="row" items="${readerList}">
				<tr>
				
					
					<td>${row.id }</td>
					<td>${row.username}</td>
					<td>${row.firstName}</td>
					<td>${row.lastName}</td>
					<td>${row.contactNo }</td>
					<td>${row.email }</td>
					<td>${row.password}</td>
					<td>${row.photoName}</td>
					
					

				</tr>

			</c:forEach>

		</tbody>


	</table>
	<hr/> Transaction List
	<table id="transactionList" border="1" style="border-collapse: collapse;">
		<thead>
			<tr>
				<th></th>
				<th>Document</th>
				<th>Reader</th>
				<th>Borrowed Date </th>
				
				

			</tr>
		</thead>

		<tbody>
			<c:forEach var="row" items="${transactionList}">
				<tr>
					<td>
					<button class="btn btn-success" style="color: black"
							onclick="returnDocument(${row.transId },${row.doc_code.doc_code})">Return</button>
					
					</td>
							
					<td>${row.doc_code.doc_name }</td>
					<td>${row.reader_id.username}</td>
					<td>${row.loanedDate}</td>
					
					
					

				</tr>

			</c:forEach>

		</tbody>
		
	
	</table>
	
	<script type="text/javascript">
		function returnDocument(transId, doc_code){
			var r = confirm("Are you sure you want to return this document?");
			if(r==true){
				location.href= "${pageContext.request.contextPath}/borrowDoc/" +transId + "/" +doc_code +"/return";
			}
			
		}
		
		
	
	</script>

</body>
</html>