package models;

import java.sql.*;
import java.util.ArrayList;
public class User{
	private Integer userId;
	private String name;
	private String email;
	private String password;
	private Date dob;
	private Nation nation;
	private String areaOfInterest;
	private String organization;
	private String currentProfile;
	private Integer questionCount;
	private Integer responseCount;
	private Status status;
	private User_Types userType;

	

/*   CONSTRUCTORS  */
	public User(){
		
	}

	public User(String email,String password){
		this.email = email;
		this.password = password;
	}

	public User(Date dob,String organization){
		this.dob = dob;
		this.organization = organization;
	}

	public User(String email,String password,String name){
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public User(Integer userId,String name){
		this.userId = userId;
		this.name = name;
	}

/* other methods   */
public boolean loginUser(){
		boolean flag = false;
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=12345656");

			String query = "select * from users where email=? and password=?";
			PreparedStatement p = con.prepareStatement(query);

			p.setString(1,email);
			p.setString(2,password);

			ResultSet r = p.executeQuery();

			if(r.next()){
				flag = true;
				this.userId = r.getInt(1);
				this.name = r.getString(2);
				this.dob = r.getDate(3);
				this.organization = r.getString(4);
			}
		}catch(SQLException x){
			x.printStackTrace();
		}catch(ClassNotFoundException x){
			x.printStackTrace();
		}finally{
			try{
				con.close();		
			}catch(SQLException x){
				x.printStackTrace();
			}
		}

		return flag;
	}

	public boolean registerUser(){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=12345656");

			String query = "insert into users (name,email,password,user_type_id) values (?,?,?,1)";
			PreparedStatement p = con.prepareStatement(query);

			p.setString(1,name);
			p.setString(2,email);
			p.setString(3,password);

			int r = p.executeUpdate();
			if(r==1){
				flag = true;
			}
		}catch(SQLException x){
			x.printStackTrace();
		}catch(ClassNotFoundException x){
			x.printStackTrace();
		}finally{
			try{
				con.close();		
			}catch(SQLException x){
				x.printStackTrace();
			}
		}

		return flag;
	}
	
	
	public boolean updateProfile(int user_id,int nation_id){
		boolean flag = false;
		System.out.println(dob);
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=12345656");
			String query = "update users set dob=?,organization=?,nation_id=? where user_id=?";
			PreparedStatement ps= con.prepareStatement(query);
			ps.setDate(1,dob);
			ps.setString(2,organization);
			ps.setInt(3,nation_id);
			//user.setNation(ps.setInt(3,new Nation(int nation_id)))
			ps.setInt(4,user_id);
			int res = ps.executeUpdate();
			if(res==1){flag = true;}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
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

	public static ArrayList<User> getUserInfo(int userId){
		ArrayList<User> users = new ArrayList<User>();
		Connection con = null;
		try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=12345656");
				String query="select user_id,name,dob,u.nation_id,organization,question_count,response_count,nation from users as u inner join nation as n where user_id=? and n.nation_id=u.nation_id";
				PreparedStatement p = con.prepareStatement(query);
				p.setInt(1,userId);
				ResultSet r = p.executeQuery();
				while(r.next()){
					User user = new User();
					user.userId = r.getInt(1);
					user.name = r.getString(2);
					user.dob = r.getDate(3);
					//user.nation_id = r.getInt(4);
					user.setNation(new Nation(r.getInt(4),r.getString(8)));
					user.organization = r.getString(5);
					user.questionCount = r.getInt(6);
					user.responseCount = r.getInt(7);
					/*question.setPostDateTime(r.getTimestamp(5));
					question.setUser(new User(r.getInt(6),r.getString(7)));
					question.setStatus(new Status(r.getInt(8),r.getString(9)));*/
					//question.post = post;
					users.add(user);
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
		return users;
	}

	public static ArrayList<User> getUserReport(){
		ArrayList<User> reports = new ArrayList<User>();
		Connection con = null;
		try{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=12345656");
				String query="select user_id,name,email,question_count,response_count from users";
				PreparedStatement p = con.prepareStatement(query);
				ResultSet r = p.executeQuery();
				while(r.next()){
					User user = new User();
					user.userId = r.getInt(1);
					user.name = r.getString(2);
					user.email = r.getString(3);
					user.questionCount = r.getInt(4);
					user.responseCount = r.getInt(5);
					reports.add(user);
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
		return reports;
	}
	
// ###########   Setter-Getter methods  ##########	
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	
	public Integer getUserId(){
		return userId;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}

	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}

	public void setDob(Date dob){
		this.dob = dob;
	}
	public Date getDob(){
		return dob;
	}

	public void setNation(Nation nation){
		this.nation = nation;
	}
	public Nation getNation(){
		return nation;
	}

	public void setAreaOfInterest(String areaOfInterest){
		this.areaOfInterest = areaOfInterest;
	}
	public String getAreaOfInterest(){
		return areaOfInterest;
	}

	public void setOrganization(String organization){
		this.organization = organization;
	}
	public String getOrganization(){
		return organization;
	}

	public void setCurrentProfile(String currentProfile){
		this.currentProfile = currentProfile;
	}
	public String getCurrentProfile(){
		return currentProfile;
	}

	public void setQuestionCount(Integer questionCount){
		this.questionCount = questionCount;
	}
	public Integer getQuestionCount(){
		return questionCount;
	}

	public void setResponseCount(Integer responseCount){
		this.responseCount = responseCount;
	}
	public Integer getResponseCount(){
		return responseCount;
	}

	public void setStatus(Status status){
		this.status = status;
	}
	public Status getStatus(){
		return status;
	}

	public void setUserType(User_Types userType){
		this.userType = userType;
	}
	public User_Types getUserType(){
		return userType;
	}
}
