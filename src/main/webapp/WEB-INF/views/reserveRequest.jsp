<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			$("#requestList").DataTable();
		});
		
		
	</script>
</head>
<body>

	<%=session.getAttribute("activeUser")%> |
	<a href="${pageContext.request.contextPath}/logout ">Log Out</a>
	<br/>
	<hr/>
	
	<br /> Request List:
	<table id="requestList" border="1" style="border-collapse: collapse;">
		<thead>
			<tr>
				<th></th>
				<th>Request Date</th>
				<th>Document Info</th>
				<th>Reader Info</th>
				
				

			</tr>
		</thead>

		<tbody>
			<c:forEach var="row" items="${requestList}">

				<tr>
					<td>
						<button class="btn btn-info" style="color: black"
							onClick = "reserve(${row.reqId})" >Confirm</button>
							
						<button class="btn btn-danger" style="color: black"
							onClick = "deleteReserve(${row.reqId} )" >Delete</button>

					</td>
					<td>${row.reserveDate}</td>
					<td>${row.doc_code.doc_name}</td>
					<td>${row.reader_id.username}</td>
					
					
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<script type="text/javascript">
		function reserve(reqId){
			var r = confirm("Are you sure you want to confirm?");
			if(r==true){
				location.href = "${pageContext.request.contextPath}/reserveReq/" + reqId + "/confirmReservation";
			}
		}	
	
		
		function deleteReserve(reqId){
			var r = confirm("Are you sure you want to delete?");
			if(r==true){
				
			}
		}
	
	
	</script>

</body>
</html>