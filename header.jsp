<%@ page import="models.User" %> 

<div id="header">
			<% User user = (User)session.getAttribute("user"); %>
			<% Integer pg = (Integer)request.getAttribute("page"); %>
			<% Integer isAdmin = (Integer)request.getAttribute("isAdmin"); %>
			<% Boolean isLogin = (Boolean)request.getAttribute("isLoginPage"); %>
			<% String isUser = (String)request.getAttribute("isUser"); %>
			<div id="logo">
				<% if(isAdmin==null){ %>
				<a href='index.jsp'><img src="images/otdf1.png" height="100" width="200"/></a>
				<% }else{ %>
				<a href='index.jsp'><img src="../images/otdf1.png" height="100" width="200"/></a>
				<% } %>
			</div>
			<div id="menu">
				<% if(user==null){ %>
					<% if(isLogin == null){ %>
						<a href="login.do" class="a">Login</a>&nbsp;&nbsp;
					<% } %>
				<% if(pg==null){ %>
				<a href="register.do" class="a">Register</a>&nbsp;&nbsp;
				<% } %>
				<% }else{ %>
				<% if(isAdmin!=null){ %><a href="logout.do" class="a">Logout</a>
				<% }else{ %>
						<a href="userlogout.do" class="a">Logout</a>
					<% } %>
				<% } %>
			</div>
			 <% if(user != null){ %>
			<div id="welcome">
				<a href="update_profile.do?user_id=<%= user.getUserId() %>" style="color:white;">
				<% if(isAdmin==null){ %>
					<img src="images/profile.jpg" height="28px" width="40px" />
				<% }else{ %>
					<img src="../images/profile.jpg" height="28px" width="40px" />
				<% } %>
				
				Welcome <%= user.getName() %>
				</a>
			</div>
			<% } %>
</div>