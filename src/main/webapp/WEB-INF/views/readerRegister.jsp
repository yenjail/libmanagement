<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.dataTables.css">
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="http://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script type="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script type="${pageContext.request.contextPath}/resources/js/jquery.dataTables.js"></script>

<script>
$(document).ready(function(){
	$("#readerList").DataTable();
});

function checkExist(){
    console.log("checkExist click");
	var xmlhttp = new XMLHttpRequest();
    var username = document.forms["regF"]["username"].value;
    var url = "http://localhost:8080/libraryManagement/userCheck.jsp?username=" + username;
    console.log(window.location);
    xmlhttp.onreadystatechange = function(){
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            if(xmlhttp.responseText == "\n\n\n\n\nUser already exists")
                document.getElementById("isE").style.color = "red";
            else
                document.getElementById("isE").style.color = "green";
            document.getElementById("isE").innerHTML = xmlhttp.responseText;
        }
        
    };
    try{
    xmlhttp.open("GET",url,true);
    xmlhttp.send();
}catch(e){
	alert("unable to connect to server");
}
}


</script>

</head>
<body>
	Welcome:
	<%=session.getAttribute("activeUser")%>
	|
	<a href="${pageContext.request.contextPath}/logout "> Logout User</a>
	<br />
	<hr />

	<a href="${pageContext.request.contextPath}/documentReg ">Add a
		document record</a> | &nbsp;
	<hr />
	<h2>Register Reader</h2>
	<div class="alert alert-danger" role="alert"> ${readerError}  </div>
	<form:form method="POST" modelAttribute="reader"
		enctype="multipart/form-data" name="regF">
		<table>
			<tr>
				<td><form:label path="username">User Name</form:label></td>
				<td><input type="text" name="username" onblur="checkExist()"/><span id="isE"></span></td>
				
			</tr>
			

			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>

			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>

			<tr>
				<td><form:label path="contactNo">Contact Number</form:label></td>
				<td><form:input path="contactNo" /></td>
			</tr>

			<tr>
				<td><form:label path="email">Email Address </form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			
			<tr>
				<td><form:label path="password">Password </form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			
			
		
			
			<tr>
				<td>Upload</td>
				<td><input type="file" name="file"></td>
			</tr>
			
			<tr>
				<td colspan="2"><input class="btn btn-info" type="submit" value="Register" /></td>
			</tr>
			
			
		</table>
		
		


		<form:hidden path="id" />

	</form:form>
	
	
	
	<br/>
	<br/>
	<h2>${successMsg}</h2>
	
	
	



	<hr />

	Reader list:
	<br />
	<table id="readerList" border="1" style="border-collapse: collapse;">
		<thead>
			<tr>
				<th></th>
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
					<td>
						<button class="btn btn-success" style="color: black" onclick="editReader(${row.id})">Edit</button>
						<button class="btn btn-danger" style="color: black" onclick="deleteReader(${row.id})">De-Register</button>
					</td>
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
	

	<script type="text/javascript">
		function editReader(id){
			location.href= "${pageContext.request.contextPath}/readerReg/" + id + "/edit";
		}
		function deleteReader(id){
			var r = confirm("Are you sure you want to de-register?");
			if(r==true){
				location.href= "${pageContext.request.contextPath}/readerReg/" + id + "/delete";
			}
		}
		
		$(document).ready(function(){
			$("#readerList").DataTable();
		});
		
		
		
	</script>





</body>
</html>