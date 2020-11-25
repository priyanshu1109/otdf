package models;
import java.sql.*;
import java.util.*;


public class Question extends Post{
	private Integer questionId;
	private Topic topic;
	//private Post post;
	private String title;
	private Integer responseCount;
	private Integer viewCount;

	public Question(){
	
	}

	public Question(int questionId){
		this.questionId = questionId;
	}
//---------------------OTHER METHODS-----------------------



	

	public boolean saveQuestion(){
		savePost();
		boolean flag = false;
			Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
			String query="insert into question (title,topic_id,post_id) value (?,?,?)";
			PreparedStatement p = con.prepareStatement(query);
			p.setString(1,title);
			p.setInt(2,topic.getTopicId());
			p.setInt(3,getPostId());

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

	public static ArrayList<Question> collectQuestions(Integer topicId){
		ArrayList<Question> questions = new ArrayList<Question>();
		Connection con = null;
		try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
				String query="select question_id,title,q.response_count,view_count,post_date_time,p.user_id,name,p.status_id,status,p.post_id,like_count from question as q inner join post as p inner join users as u inner join status as s where topic_id=? and q.post_id=p.post_id and p.status_id=s.status_id and p.user_id=u.user_id";
				PreparedStatement p = con.prepareStatement(query);
				p.setInt(1,topicId);
				ResultSet r = p.executeQuery();
				while(r.next()){
					Question question = new Question();
					question.questionId = r.getInt(1);
					question.title = r.getString(2);
					question.responseCount = r.getInt(3);
					question.viewCount = r.getInt(4);
					
					//Post post = new Post();
					question.setPostDateTime(r.getTimestamp(5));
					question.setUser(new User(r.getInt(6),r.getString(7)));
					question.setStatus(new Status(r.getInt(8),r.getString(9)));
					question.setPostId(r.getInt(10));
					question.setLikeCount(r.getInt(11));
					//question.post = post;
					questions.add(question);
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
		return questions;
	}

	public static ArrayList<Question> getQuestionInfo(Integer question_id){
		ArrayList<Question> questions1 = new ArrayList<Question>();
		Connection con = null;
		try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");
				String query="select question_id,title,q.response_count,view_count,post_date_time,p.post,p.user_id,name,p.status_id,status,p.like_count from question as q inner join post as p inner join users as u inner join status as s where question_id=? and q.post_id=p.post_id and p.status_id=s.status_id and p.user_id=u.user_id";
				PreparedStatement p = con.prepareStatement(query);
				p.setInt(1,question_id);
				ResultSet r = p.executeQuery();
				while(r.next()){
					Question question1 = new Question();
					question1.questionId = r.getInt(1);
					question1.title = r.getString(2);
					question1.responseCount = r.getInt(3);
					question1.viewCount = r.getInt(4);
					
					//Post post = new Post();
					question1.setPostDateTime(r.getTimestamp(5));
					question1.setPost(r.getString(6));
					question1.setUser(new User(r.getInt(7),r.getString(8)));
					/*question1.setLikeCount(r.getInt(9));
					question1.setDislikeCount(r.getInt(10));
					question1.setSpamCount(r.getInt(11));*/
					question1.setStatus(new Status(r.getInt(9),r.getString(10)));
					//question.post = post;
					question1.setLikeCount(r.getInt(11));
					questions1.add(question1);
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
		return questions1;
	}


//----------------------GETTER-SETTER---------------------
	public void setQuestionId(Integer questionId){
		this.questionId = questionId;
	}
	public Integer getQuestionId(){
		return questionId;
	}

	public void setTopic(Topic topic){
		this.topic = topic;
	}
	public Topic getTopic(){
		return topic;
	}

	/*public void setPost(Post post){
		this.post = post;
	}
	public Post getPost(){
		return post;
	}*/
	
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	}

	public void setResponseCount(Integer responseCount){
		this.responseCount = responseCount;
	}
	public Integer getResponseCount(){
		return responseCount;
	}

	public void setViewCount(Integer viewCount){
		this.viewCount = viewCount;
	}
	public Integer getViewCount(){
		return viewCount;
	}
}