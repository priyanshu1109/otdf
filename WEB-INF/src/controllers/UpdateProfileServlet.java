package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.Date;
import java.util.ArrayList;
import models.*;

public class UpdateProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextPage = "user_profile1.jsp";
		System.out.println(request.getParameter("user_id"));
		System.out.println(request.getParameter("nation_id"));
		System.out.println(request.getParameter("dob"));
		System.out.println(request.getParameter("organization"));

		int user_id = Integer.parseInt(request.getParameter("user_id"));
		int nation_id = Integer.parseInt(request.getParameter("nation_id"));
		ArrayList<User> users = User.getUserInfo(user_id);
		//ArrayList<Nation> nations = Nation.getAllNations();
		request.setAttribute("users",users);	
		//request.setAttribute("nations",nations);
		Date dob = null;
		String organization=null;
		if(request.getParameter("dob")!=""){
			dob = Date.valueOf((request.getParameter("dob")));
		}
		if(request.getParameter("organization")!=null){
			organization = request.getParameter("organization");
		}
		User user = new User(dob,organization);
		if(user.updateProfile(user_id,nation_id)){
			nextPage = "update_profile.do";
		}
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}