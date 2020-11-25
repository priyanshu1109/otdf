<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
 <head>
  <title>Document</title>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/header.css" />
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
	<link rel="stylesheet" type="text/css" href="css/postQuestion.css" />

 </head>
 <body>
	<div id="main-container">
		<c:import url="header.jsp" />
		<div align="center">
			<h1><font color="red">Topic Name : &nbsp;&nbsp;&nbsp;</font><font color="red"><%= request.getParameter("topic") %></font></h1>
			
			
		</div>
		<form action="submit_question.do" id="post_form">
			<font color="#ff6633" size="6px">Title:-</font>&nbsp;&nbsp;<input type="text" name="q_title" id="q_tit" /><br/><br/><br/><br/>
			<font color="#ff6633" size="6px">Question Description:-</font><br/><br/>
			<textarea id ="q_desc" name="question" id="q_desc"></textarea><br/><br/>
			<input type="submit" value="submit" id="post_submit" />
			<input type="hidden" name="topic_id" value="<%= request.getParameter("topic_id") %>" />
			<input type="hidden" name="topic" value="<%= request.getParameter("topic") %>" />
		</form>
		<c:import url="footer.jsp" />
	</div>
	<script src="js/common.js"></script>
 </body>
</html>
