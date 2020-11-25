
<!doctype html>
<html lang="en">
 <head>
  <title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/common.css" />
	<link rel="stylesheet" type="text/css" href="../css/header.css" />
	<link rel="stylesheet" type="text/css" href="../css/footer.css" />
	<link rel="stylesheet" type="text/css" href="../css/admin_menu.css" />

 </head>
 <body>
	<div id="main-container">
		<% request.setAttribute("isAdmin",1); %>
		<div class="topnav">
			<a class="active" href="admin_topics.do">Topics</a>
			<a href="user_reports.do">User reports</a>
		</div>
		
	</div>
	<script src = "../js/common.js"></script>
 </body>
</html>