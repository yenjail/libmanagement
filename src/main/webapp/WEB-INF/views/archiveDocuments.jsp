<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
		
		
	</script>
</head>
<body>

<hr />
	<br />Archived Document list:
	<table id="documentList" border="1" style="border-collapse: collapse;">
		<thead>
			<tr>
				<th></th>
				<th>Document Name</th>
				<th>Original Version</th>
				<th>Digital Version</th>
				<th>Genre</th>
				<th>Author</th>
				<th>Date of last loan</th>
				<th>Summary</th>
				

			</tr>
		</thead>

		<tbody>
			<c:forEach var="row" items="${documentList}">

				<tr>
					<td>
						
						<button class="btn btn-info" style="color: black"
							onclick="archiveDocument(${row.doc_code})">Restore</button>

					</td>
					<td>${row.doc_name}</td>
					<td>${row.original_version}</td>
					<td>${row.digital_version}</td>
					<td>${row.genre}</td>
					<td>${row.author}</td>
					<td><fmt:formatDate value="${row.registerDate }" pattern="MM/dd/yyyy" /></td>
					<td>${row.summary}</td>
					
				</tr>

			</c:forEach>
		</tbody>
	</table>	
	
	<a href="${pageContext.request.contextPath}/documentReg ">Add a document record</a> | &nbsp;
	
	<script type="text/javascript">
	function deleteDocument(doc_code){
		var r = confirm("Are you sure you want to remove the document?");
		if(r==true){
			location.href= "${pageContext.request.contextPath}/archivedDoc/" + doc_code + "/delete";
		}
	}
	function archiveDocument(doc_code){
		var r = confirm("Are you sure you want to archive the document?");
		if(r==true){
			location.href= "${pageContext.request.contextPath}/archivedDoc/" + doc_code +"/restore";
		}
	}
	</script>

</body>
</html>