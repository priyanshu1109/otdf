<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
 <head>
  <title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/user_reports.css" />
	<link rel="stylesheet" type="text/css" href="../css/common.css" />
	<link rel="stylesheet" type="text/css" href="../css/header.css" />
	<link rel="stylesheet" type="text/css" href="../css/footer.css" />
 </head>
 <body>
	<% request.setAttribute("isAdmin",1); %>
	<div id="main-container">
		<%@ include file="../header.jsp" %>
		<%@ include file="admin_menubar.jsp" %>
	
		<table id="user_reports">
				<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Question Count</th>
					<th>Response Count</th>
				</tr>
				</thead>
				<tbody>
			<c:forEach var="report" items="${reports}">
				<tr>
					<td><c:out value="${report.getName()}" /></td>
					<td><c:out value="${report.getEmail()}" /></td>
					<td><c:out value="${report.getQuestionCount()}" /></td>
					<td><c:out value="${report.getResponseCount()}" /></td>
				</tr>
			</c:forEach>
				</tbody>
		</table>

		<%@ include file="../footer.jsp" %>
	</div>
	<script src = "../js/common.js"></script>
 </body>
</html>
