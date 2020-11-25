package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.*;

import models.*;
import com.google.gson.Gson;

public class CollectTopicsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String topicStr = null;
		User user = (User)session.getAttribute("user");
			ArrayList<Topic> topic = Topic.collectTopics();
			topicStr = new Gson().toJson(topic);

		response.getWriter().write(topicStr);
	}
}