<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList,models.User" %>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>User-profile</title>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/header.css" />
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
	<link rel="stylesheet" type="text/css" href="css/index.css" />
	<link rel="stylesheet" type="text/css" href="css/user-profile.css" />
 </head>
 <body>
	
	<div id="main-container">
		<c:import url="header.jsp" />
		<c:forEach var="user1" items="${users}">
		<h2 id="name"><c:out value="${user1.getName()}" /></h2>
		<div class="user-pic">
			<div class="user-pic">
                                <img src="images/user-bg.png" id="user_image1" alt="">
                                <input type="file" id="upload" style="display:none" />
								<a href="#"><span><img src="images/edit.png" alt="" onclick="document.getElementById('upload').click();" ></span></a>
								
            </div>
        </div>
		<br /><br />
		<hr color="#3366ff"/>
		<form>
		<table align="center" border="0" class="user-profile-table">
			<tr>
				<td align="center" width="40%">Date of Birth</td>
				<td align="center">:</td>
				<td align="center"><c:out value="${user1.getDob()}" /></td>
			</tr>
			<tr>
				<td align="center" width="40%">Country</td>
				<td align="center">:</td>
				<td align="center"><c:out value="${user1.getNation().getNation()}" /></td>
			</tr>
			<tr>
				<td align="center" width="40%">Organisation</td>
				<td align="center">:</td>
				<td align="center"><c:out value="${user1.getOrganization()}" /></td>
			</tr>
			<tr>
				<td align="center" width="40%">Question_count</td>
				<td align="center">:</td>
				<td align="center"><c:out value="${user1.getQuestionCount()}" /></td>
			</tr>
			<tr>
				<td align="center" width="40%">Response_count</td>
				<td align="center">:</td>
				<td align="center"><c:out value="${user1.getResponseCount()}" /></td>
			</tr>
			</c:forEach>
		</table>
		</form>
		<script src="js/common.js"></script>
		<c:import url="footer.jsp" />
	</div>
 </body>
</html>
