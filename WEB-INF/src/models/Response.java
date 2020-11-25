package models;

import java.sql.*;
import java.util.ArrayList;

public class Response extends Post{
	private Integer responseId;
	private Question question;
	//private Post post;

	public Response(){
	
	}

	public static ArrayList<Response> getResponses(Integer question_id){
		ArrayList<Response> response1 = new ArrayList<Response>();
		Connection con = null;
		try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
				String query="select response_id,r.post_id,post_date_time,post,p.user_id,name,p.status_id,status from response as r inner join post as p inner join users as u inner join status as s where question_id=? and r.post_id=p.post_id and p.status_id=s.status_id and p.user_id=u.user_id";
				PreparedStatement p = con.prepareStatement(query);
				p.setInt(1,question_id);
				ResultSet r = p.executeQuery();
				while(r.next()){
					Response response = new Response();
					response.responseId = r.getInt(1);
					response.setPostId(r.getInt(2));
					//Post post = new Post();
					response.setPostDateTime(r.getTimestamp(3));
					response.setPost(r.getString(4));
					response.setUser(new User(r.getInt(5),r.getString(6)));
					response.setStatus(new Status(r.getInt(7),r.getString(8)));
					response1.add(response);
				}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return response1;
	}
	
public boolean increaseCount(){
	boolean flag = false;
	Connection con = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
		String query="update question set response_count=response_count+1 where question_id=?";
		PreparedStatement p = con.prepareStatement(query);
		p.setInt(1,question.getQuestionId());
		int res = p.executeUpdate();
		if(res==1){
			flag = true;
		}

	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	return flag;
}

public boolean saveResponse(){
	savePost();
	increaseCount();
	boolean flag = false;
	Connection con = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
		String query="insert into response (question_id,post_id) value (?,?)";
		PreparedStatement p = con.prepareStatement(query);
		p.setInt(1,question.getQuestionId());
		p.setInt(2,getPostId());

		int res = p.executeUpdate();
		if(res==1){
			flag = true;
		}

	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	return flag;
}
		

	public void setResponseId(Integer responseId){
		this.responseId = responseId;
	}
	public Integer getResponseId(){
		return responseId;
	}

	public void setQuestion(Question question){
		this.question = question;
	}
	public Question getQuestion(){
		return question;
	}

	/*public void setPost(Post post){
		this.post = post;
	}
	public Post getPost(){
		return post;
	}*/
}