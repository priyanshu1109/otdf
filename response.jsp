<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList,models.Question" %>
<!doctype html>
<html lang="en">
 <head>
  <title>Document</title>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/header.css" />
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
	<link rel="stylesheet" type="text/css" href="css/postQuestion.css" />
	<link rel="stylesheet" type="text/css" href="css/description.css" />
 </head>
 <body>
	<div id="main-container">
		<c:import url="header.jsp" />
		<c:forEach var='question' items="${questions}">
				
		<h1 class="title_head"><u><c:out value="${question.getTitle()}"/></u></h1>
		<div class="description1">
			<c:out value="${question.getPost()}" />
		</div>
		</c:forEach>
		<input type="hidden" value=<%= request.getParameter("question_id") %> id="question_id" />

		<form action="submit_response.do" id="post_form">
			<br/><br/>
			<font color="#ff6633" size="6px">Answer Description:-</font><br/><br/>
			<textarea name="response" id="r_desc"></textarea><br/><br/>
			<div class="activity1">
			<input type="submit" value="submit" class="answer_btn" />
			</div>
			<input type="hidden" name="question_id" value="<%= request.getParameter("question_id") %>" />
			<input type="hidden" name="post_id" value="<%= request.getParameter("post_id") %>" />
		</form>
		<c:import url="footer.jsp" />
	</div>
	<script src="js/common.js"></script>
 </body>
</html>
