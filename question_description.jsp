<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList,models.Question" %>
 <!doctype html>
<html lang="en">
 <head>
  <title>Document</title>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/header.css" />
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
	<link rel="stylesheet" type="text/css" href="css/description.css" />
 </head>
 <body>
	
	<div id="main-container">
		<c:import url='header.jsp'/>
	
		<c:forEach var='question' items="${questions}" >
				
		<h1 class="title_head"><u><c:out value="${question.getTitle()}"/></u></h1>
		<div class="description">
			<c:out value="${question.getPost()}" />
		</div>
		
		<div class="activity">
		<div class="btn-group">
			<button class="btn-main" id="like"><img src="images/btn-ic1.png" alt=""><c:out value="${question.getLikeCount()}" /></button>
			
			<button class="btn-main" id="dislike"><img src="images/rsz_dislike.png" alt="">  </button>
			<button class="btn-main" id="spam"><img src="images/.png" alt=""> <c:out value="${question.getSpamCount()}" /> </button>
		</div>
		<button class="answer_btn" id="ans_btn">Answer</button>
		</div>
		</c:forEach>
		<input type="hidden" value=<%= request.getParameter("question_id") %> id="question_id" />
		<input type="hidden" value=<%= request.getParameter("post_id") %> id="post_id" />
		<input type="hidden" value='<c:out value="${liked}"/>' id="liked" />
		<input type="hidden" value='<c:out value="${disliked}"/>' id="disliked" />
		<input type="hidden" value='<c:out value="${spam}"/>' id="spamed" />
		<div style="margin-left:30px;padding:4px 4px 4px 4px"><h3 style="color:red"><u>Answers</u></h3></div>
		
		<c:forEach var='response' items="${responses}">
		<div class="response">
			<div class="user-info">
				<h2><a href='user_profile.do?user_id=<c:out value="${response.getUser().getUserId()}" />'><c:out value="${response.getUser().getName()}" /></a>
					<span><c:out value="${response.getPostDateTime()}" /></span>
				</h2>
			</div>
			<c:out value="${response.getPost()}" />
		</div>
		<br /><br />
		</c:forEach>
		<c:import url='footer.jsp'/>
	</div>
	<script src="js/common.js"></script>
	<script type="text/javascript">
		var question_id = document.getElementById("question_id").value;
		var post_id = document.getElementById("post_id").value;
		var answer_btn = document.getElementById("ans_btn");
		answer_btn.onclick = function(){ window.location.href= "response.do?question_id="+question_id+"&post_id="+post_id;}
	</script>
	<script src="js/like.js"></script>
	<script src="js/dislike.js"></script>
 </body>
</html>
