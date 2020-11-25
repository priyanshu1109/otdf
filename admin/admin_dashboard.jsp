
<!doctype html>
<html lang="en">
 <head>
  <title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/common.css" />
	<link rel="stylesheet" type="text/css" href="../css/header.css" />
	<link rel="stylesheet" type="text/css" href="../css/footer.css" />
 </head>
 <body>
	<% request.setAttribute("isAdmin",1); %>
	<div id="main-container">
		<%@ include file="../header.jsp" %>
		<%@ include file="admin_menubar.jsp" %>
		<%@ include file="../footer.jsp" %>
		<%-- <%@ include file="admin_topics.jsp" %> --%>
	</div>
	<script src = "../js/common.js"></script>
 </body>
</html>