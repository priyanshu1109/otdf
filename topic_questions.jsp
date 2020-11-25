<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="java.util.ArrayList,models.Question" %>
 <!doctype html>
<html lang="en">
 <head>
  <title>Document</title>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/header.css" />
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
	<link rel="stylesheet" type="text/css" href="css/index.css" />
	<link rel="stylesheet" type="text/css" href="css/records.css" />
	<link rel="stylesheet" type="text/css" href="css/topic_question.css" />
 </head>
 <body>
	
	<div id="main-container">
		
		<c:import url="header.jsp" />
		<% ArrayList<Question> questions = (ArrayList)request.getAttribute("questions"); %>
		<div id="tp_title">
			<span class="blnking">&nbsp;<%= request.getParameter("topic") %>&nbsp;</span>
			<input type="button" id="tp_button" value="Post New Question" />
			<input type="hidden" id="tp_id" value=<%= request.getParameter("topic_id") %> />
			<input type="hidden" id="tp_nm" value=<%= request.getParameter("topic") %> />
		</div>
		<br/>
		<table id="question_table">
			<thead>
				<tr>
					<th>Sr.No.</th>
					<th>Title</th>
					<th>User</th>
					<th>Date/time</th>
					<th>response/view count</th>
				</tr>	
			</thead>
			<tbody>
				<% int i=0; %>
				<% if(questions.size()==0){ %>
					<tr>
						<td colspan="5" id="no_rec">No Matches Found</td>
					</tr>
				<% }else{ %>
					<% for(Question question:questions){ %>
					<tr>
						<td><%= ++i %></td>
						<td><a href="question_desc.do?question_id=<%= question.getQuestionId() %>&post_id=<%= question.getPostId() %>"><%= question.getTitle() %></td>
						<td><a href="user_profile.do?user_id=<%= question.getUser().getUserId() %>"><%= question.getUser().getName() %></a></td>
						<td><%= question.getPostDateTime() %></td>
						<td><%= question.getResponseCount()+"/"+question.getViewCount() %></td>
					</tr>
					<% } %> 
				<% } %>
			</tbody>
		</table>
		<c:import url="footer.jsp" />
	</div>
	<script src="js/common.js"></script>
	<script src="js/tpbutton.js"></script>
 </body>
</html>
