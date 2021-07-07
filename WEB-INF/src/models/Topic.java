package models;
import java.sql.*;
import java.util.*;
public class Topic{
	private Integer topicId;
	private String topic;
	private Integer questionCount;
	private Integer openQuestion;
	private Timestamp lastUpdate;
	private Status status;

	public Topic(){
	
	}

	public Topic(Integer topicId){
		this.topicId = topicId;
	}

	public Topic(Integer topicId,String topic){
		this.topicId = topicId;
		this.topic = topic;
	}
	
	public boolean saveTopic(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=123456");
			String query = "insert into topics (topic) values(?)";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,topic);
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

	public static ArrayList<Topic> collectTopics(){
		ArrayList<Topic> topics = new ArrayList<Topic>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=123456");
			String query = "select * from topics";
			PreparedStatement ps= con.prepareStatement(query);
			ResultSet r = ps.executeQuery();
			while(r.next()){
				Topic tp = new Topic();
				tp.topicId = r.getInt(1);
				tp.topic = r.getString(2);
				tp.questionCount = r.getInt(3);
				tp.openQuestion = r.getInt(4);
				tp.lastUpdate = r.getTimestamp(5);
				tp.status = new Status(r.getInt(6));
				topics.add(tp);
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
		return topics;
	}
	
	public static boolean increaseQuestionCount(int topic_id){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=123456");
			String query = "update topics set question_count=question_count+1,open_question=open_question+1 where topic_id=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setInt(1,topic_id);
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
	
	public void setTopicId(Integer topicId){
		this.topicId = topicId;
	}
	public Integer getTopicId(){
		return topicId;
	}

	public void setTopic(String topic){
		this.topic = topic;
	}
	public String getTopic(){
		return topic;
	}

	public void setQuestionCount(Integer questionCount){
		this.questionCount = questionCount;
	}
	public Integer getQuestionCount(){
		return questionCount;
	}

	public void setOpenQuestion(Integer openQuestion){
		this.openQuestion = openQuestion;
	}
	public Integer getOpenQuestion(){
		return openQuestion;
	}

	public void setLastUpdate(Timestamp lastUpdate){
		this.lastUpdate = lastUpdate;
	}
	public Timestamp getLastUpdate(){
		return lastUpdate;
	}

	public void setStatus(Status status){
		this.status = status;
	}
	public Status getStatus(){
		return status;
	}
}