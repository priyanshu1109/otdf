<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList,models.*" %>
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
	<% ArrayList<User> users = (ArrayList)request.getAttribute("users"); %>
	<% ArrayList<Nation> nations = (ArrayList)request.getAttribute("nations"); %>
	<div id="main-container">
		<c:import url="header.jsp" />
		<% for(User user2 : users){ %>
		<h2 id="name"><%= user2.getName() %></h2>
		<div class="user-pic">
			<div class="user-pic">
                                <img src="images/user-bg.png" id="user_image1" alt="">
                                <input type="file" id="upload" style="display:none" />
								<a href="#"><span><img src="images/edit.png" alt="" onclick="document.getElementById('upload').click();" ></span></a>
            </div>
        </div>
		<br /><br />
		<hr color="#3366ff"/>
		<form action="update.do" >
		<table align="center" border="0" class="user-profile-table">
			<tr>
				<td align="center" width="40%">Date of Birth</td>
				<td align="center">:</td>
				<td align="center"><input type="date" value="<%= user2.getDob() %>" name="dob"></td>
			</tr>
			<tr>
				<td align="center" width="40%">Country</td>
				<td align="center">:</td>
				<td align="center"><select name="nation_id">
										<% Integer un = user2.getNation().getNationId(); %>
										
										<option value="<%= user2.getNation().getNationId() %>" default selected><%= user2.getNation().getNation() %></option>
										<% for(Nation nations1:nations){ %>					
												<% Integer n = nations1.getNationId(); %>
												<% if(un!=n){ %>
												<option value="<%= nations1.getNationId() %>"><%= nations1.getNation() %></option>
											<% } %>
										<% } %>
									</select>
				</td>
			</tr> 
			<tr>
				<td align="center" width="40%">Organisation</td>
				<td align="center">:</td>
				<td align="center"><input type="text" value="<%= user2.getOrganization() %>" name="organization"></td>
			</tr>
			<tr>
				<td align="center" width="40%">Question_count</td>
				<td align="center">:</td>
				<td align="center"><%= user2.getQuestionCount() %></td>
			</tr>
			<tr>
				<td align="center" width="40%">Response_count</td>
				<td align="center">:</td>
				<td align="center"><%= user2.getResponseCount() %></td>
			</tr>
			<% } %>
		</table>
		<input type="hidden" value="<%= request.getParameter("user_id") %>" name="user_id">
		<input type="submit" value="Update Profile" class="update_btn"/>
		</form>
		<script src="js/common.js"></script>
		<script src="js/upload.js"></script>
		<%@ include file="footer.jsp" %>
	</div>
 </body>
</html>
