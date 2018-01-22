<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css ">

</head>
<body>

	<div class="alert alert-danger" role="alert"> ${loginError }  </div>
	<div class="alert alert-danger" role="alert"> ${readerloginError } </div>
  
  <section class="loginform cf">
  		<h2>Librarian</h2>
		<form action="profile" method="post" model="user" accept-charset="utf-8">
			<ul>
				<li>
					<label for="username">Username</label>
					<input type="text" name="username" placeholder="username" required>
				</li>
				<li>
					<label for="password">Password</label>
					<input type="password" name="password" placeholder="password" required></li>
				<li>
					<input type="submit" value="Login">
				</li>
			</ul>
		</form>
	 </section>
	 <section class="loginform cf">
  		<h2>Reader</h2>
		<form action="readerLogin" method="post" model="reader" accept-charset="utf-8">
			<ul>
				<li>
					<label for="username">Username</label>
					<input type="text" name="username" placeholder="username" required>
				</li>
				<li>
					<label for="password">Password</label>
					<input type="password" name="password" placeholder="password" required></li>
				<li>
					<input type="submit" value="Login"> <a href="${pageContext.request.contextPath}/signUp"> Sign Up</a>
				</li>
			</ul>
		</form>
	 </section>

</body>
</html>