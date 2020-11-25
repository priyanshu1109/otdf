<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
 <head>
  <title>Document</title>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/header.css" />
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
 </head>
 <body>
	<% request.setAttribute("isUser","user1"); %>
	<div id="main-container">
			
		<%@ include file="../header.jsp" %>
		<div id="mid-container" align="top">
			<div id="form1">
				<h1 align="center"><font color="#ff9966">User Register</font></h1>
				<br/>
				<form action="userRegister.do">
					<table id="table1">
						<tr>
							<td>User Name</td>
							<td>:</td>
							<td><input type="text" name="user_name" class="input"/></td> 
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>Email Id</td>
							<td>:</td>
							<td><input type="email" name="email" class="input"/></td> 
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>Password</td>
							<td>:</td>
							<td width="200px"><input type="password" name="password" class="input"/></td> 
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
							<input type="submit" name="submit" value="register" size="20px" class="button"/>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<%@ include file="../footer.jsp" %>
	</div>
	<script src="../js/common.js"></script>
 </body>
</html>
