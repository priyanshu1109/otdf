<!doctype html>
<html lang="en">
 <head>
  <title>Document</title>
	<link rel="stylesheet" type="text/css" href="../css/topics.css" />
	<link rel="stylesheet" type="text/css" href="../css/common.css" />
	<link rel="stylesheet" type="text/css" href="../css/header.css" />
	<link rel="stylesheet" type="text/css" href="../css/footer.css" />
 </head>
 <body>
	<% request.setAttribute("isAdmin",1); %>
	<div id="main-container">
	<%@ include file="../header.jsp" %>
	<%@ include file="admin_menubar.jsp" %>
	<table id="topic_box">
		<tr>
			<td class="td_box">
				<table id="topic_list">
					<tr>
						<th colspan="2" height="40px" class="topic_head"><font size="18px">Topics</font></th>
					</tr>
					<tr>
						<td class="topic_nm" id="topic_name">&nbsp;</td>
					</tr>
				</table>
			<td>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" placeholder="Enter name of topic" name="topic" align="center" class="input" id="topic_fld"/>
				<br/><br/><br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button class="button" id="topic_btn">Add Topics</button>
		</tr>
	</table>
	<%@ include file="../footer.jsp" %>
	</div>
	<script src = "../js/common.js"></script>
	<script src = "../js/admin_topics.js"></script>
 </body>
</html>
