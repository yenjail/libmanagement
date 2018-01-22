<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SignUp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css ">
</head>
<body>
	<section class="loginform cf">
  		<h2>Reader</h2>
		<form action="readerSignUp" method="post" model="user" accept-charset="utf-8">
			<ul>
				<li>
					<label for="username">Username</label>
					<input type="text" name="username" placeholder="username" required>
				</li>
				<li>
					<label for="firstName">First Name</label>
					<input type="text" name="firstName" placeholder="First Name" required>
				</li>
				<li>
				<label for="lastName">Last Name</label>
					<input type="text" name="lastName" placeholder="Last Name" required>
				</li>
				
				<li>
					<label for="contactNo">Contact Number</label>
					<input type="text" name="contactNo" placeholder="Contact Number" required>
				</li>
				
				<li>
					<label for="email">Email</label>
					<input type="text" name="email" placeholder="Email Address" required>
				</li>
				
				<li>
					<label for="password">Password</label>
					<input type="password" name="password" placeholder="password" required>
				</li>
				
				<li>
					<input type="submit" value="Submit">
				</li>
			</ul>
		</form>
	 </section>


</body>
</html>