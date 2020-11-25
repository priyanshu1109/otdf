<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>

<html lang="en">
 <head>
  <title>Document</title>
	<link rel="stylesheet" type="text/css" href="css/common.css" />
	<link rel="stylesheet" type="text/css" href="css/header.css" />
	<link rel="stylesheet" type="text/css" href="css/footer.css" />
	<link rel="stylesheet" type="text/css" href="css/index.css" />

 </head>
 <body>
	
	<div id="main-container">
		
		<c:import url="header.jsp" />
		<table id="topic_table">
			<tr>
				<th id="a">Sr.No.</th>
				<th>Topic</th>
				<th>All Posts</th>
				<th>Open Posts</th>
				<th>Last Update</th>
			</tr>		
		</table>
		<c:import url="footer.jsp" />
	</div>
	<script src="js/common.js"></script>
	<script src="js/topics_list.js"></script>
 </body>
</html>
