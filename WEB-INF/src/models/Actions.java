package models;
import java.sql.*;
import java.util.ArrayList;

public class Actions{
	private Integer actionId;
	private Post post;
	private User user;
	private ActionType actionType;

	//Other methods
	public static ArrayList<Actions> collectLike(Integer userId,Integer postId){
	ArrayList<Actions> actions = new ArrayList<Actions>();
	Connection con = null;
	try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query="select * from action where user_id=? and post_id=? and action_type_id=1";
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1,userId);
			p.setInt(2,postId);
			ResultSet r = p.executeQuery();
			while(r.next()){
				Actions act = new Actions();
				actions.add(act);
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
	return actions;
}

	public static ArrayList<Actions> collectSpam(Integer userId,Integer postId){
	ArrayList<Actions> actions2 = new ArrayList<Actions>();
	Connection con = null;
	try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query="select * from action where user_id=? and post_id=? and action_type_id=3";
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1,userId);
			p.setInt(2,postId);
			ResultSet r = p.executeQuery();
			while(r.next()){
				Actions act = new Actions();
				actions2.add(act);
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
	return actions2;
}

	public static ArrayList<Actions> collectDislike(Integer userId,Integer postId){
	ArrayList<Actions> actions1 = new ArrayList<Actions>();
	Connection con = null;
	try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query="select * from action where user_id=? and post_id=? and action_type_id=2";
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1,userId);
			p.setInt(2,postId);
			ResultSet r = p.executeQuery();
			while(r.next()){
				Actions act = new Actions();
				actions1.add(act);
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
	return actions1;
}

	public boolean saveLike(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query = "insert into action (post_id,user_id,action_type_id) values(?,?,?)";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,post.getPostId());
			ps.setInt(2,user.getUserId());
			ps.setInt(3,actionType.getActionTypeId());
			int res = ps.executeUpdate();
			if(res==1){flag = true;}
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

	public boolean deleteLike(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query = "delete from action where post_id=? and user_id=? and action_type_id=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,post.getPostId());
			ps.setInt(2,user.getUserId());
			ps.setInt(3,actionType.getActionTypeId());
			int res = ps.executeUpdate();
			if(res==1){flag = true;}
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
	
	public void setActionId(Integer actionId){
		this.actionId = actionId;
	}
	public Integer getActionId(){
		return actionId;
	}

	public void setPost(Post post){
		this.post = post;
	}
	public Post getPost(){
		return post;
	}

	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}

	public void setActionType(ActionType actionType){
		this.actionType = actionType;
	}
	public ActionType getActionType(){
		return actionType;
	}
}