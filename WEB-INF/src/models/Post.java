package models;
import java.sql.*;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Post{
	private Integer postId;
	private User user;
	private PostType postType;
	private String post;
	private Timestamp postDateTime;
	private Integer likeCount;
	private Integer dislikeCount;
	private Integer spamCount;
	private Status status;

	//CONSTRUCTOR
	public Post(){
	
	}

	public Post(int postId){
		this.postId = postId;
	}
	
	//OTHER METHODS
	public static ArrayList<Post> collectLike(int post_id){
		ArrayList<Post> posts = new ArrayList<Post>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query = "select like_count,dislike_count,spam_count from post where post_id=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,post_id);
			ResultSet r = ps.executeQuery();
			while(r.next()){
				Post post1 = new Post();
	
				
				post1.likeCount = r.getInt(1);
				post1.dislikeCount = r.getInt(2);
				post1.spamCount = r.getInt(3);
				
				posts.add(post1);
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
		return posts;
	}

	public static ArrayList<Post> collectDislike(int post_id){
		Connection con = null;
		ArrayList<Post> postDislike = new ArrayList<Post>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query = "select dislike_count from post where post_id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,post_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Post post2 = new Post();
	
				
				post2.dislikeCount = rs.getInt(1);
				
				postDislike.add(post2);
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
		return postDislike;
	}
	
	public static boolean updatePost(int post_id){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query = "update post set like_count=like_count+1 where post_id=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,post_id);
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

	public static boolean updatePostLike(int post_id){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query = "update post set like_count=like_count-1 where post_id=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,post_id);
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

	
	public static boolean updatePost2(int post_id){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query = "update post set spam_count=spam_count+1 where post_id=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,post_id);
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
	
	public static boolean updatePostSpam(int post_id){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query = "update post set spam_count=spam_count-1 where post_id=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,post_id);
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


	public static boolean updatePost1(int post_id){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query = "update post set dislike_count=dislike_count+1 where post_id=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,post_id);
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

	public static boolean updatePostDislike(int post_id){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query = "update post set dislike_count=dislike_count-1 where post_id=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,post_id);
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
	
	public boolean savePost(){
		boolean flag = false;
			Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query="insert into post (post,user_id,post_type_id) value (?,?,?)";
			//String query2 = "update users set question_count=question_count+1 where user_id=?";
			PreparedStatement p = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			//PreparedStatement ps = con.prepareStatement(query2);
			p.setString(1,post);
			p.setInt(2,user.getUserId());
			p.setInt(3,postType.getPostTypeId());
			//ps.setInt(1,user.getUserId());
			int r = p.executeUpdate();
			//int r2 = ps.executeUpdate();
			if(r==1){
				//increaseQuestionCount();
				ResultSet rs = p.getGeneratedKeys();
				if(rs.next()){
					postId = rs.getInt(1);
					flag = true;
				}
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

	public boolean increaseQuestionCount(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query="update users set question_count = question_count+1 where user_id=?";
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1,user.getUserId());
			int r = p.executeUpdate();
			if(r==1){
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

	public boolean increaseResponseCount(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query="update users set response_count = response_count+1 where user_id=?";
			PreparedStatement p = con.prepareStatement(query);
			p.setInt(1,user.getUserId());
			int r = p.executeUpdate();
			if(r==1){
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
	//GETTER-SETTER
	public void setPostId(Integer postId){
		this.postId = postId;
	}
	public Integer getPostId(){
		return postId;
	}

	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}

	public void setPostType(PostType postType){
		this.postType = postType;
	}
	public PostType getPostType(){
		return postType;
	}
	
	public void setPost(String post){
		this.post = post;
	}
	public String getPost(){
		return post;
	}

	public void setPostDateTime(Timestamp postDateTime){
		this.postDateTime = postDateTime;
	}
	public Timestamp getPostDateTime(){
		return postDateTime;
	}
	
	public void setLikeCount(Integer likeCount){
		this.likeCount = likeCount;
	}
	public Integer getLikeCount(){
		return likeCount;
	}

	public void setDislikeCount(Integer dislikeCount){
		this.dislikeCount = dislikeCount;
	}
	public Integer getDislikeCount(){
		return dislikeCount;
	}

	public void setSpamCount(Integer spamCount){
		this.spamCount = spamCount;
	}
	public Integer getSpamCount(){
		return spamCount;
	}

	public void setStatus(Status status){
		this.status = status;
	}
	public Status getStatus(){
		return status;
	}
}