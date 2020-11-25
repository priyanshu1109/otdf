package models;

import java.sql.*;
import java.util.*;
public class Nation{
	
	private String nation;
	private Integer nationId;

	//----------------CONSTRUCTOR------------------
	public Nation(){

	}

	public Nation(Integer nationId){
		this.nationId = nationId;
	}

	public Nation(Integer nationId,String nation){
		this.nationId = nationId;
		this.nation = nation;
	}
	//---------------------OTHER METHODS-------------------
	public static ArrayList<Nation> getAllNations(){
		ArrayList<Nation> nations = new ArrayList<Nation>();
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/otdf?user=root&password=1234");

			String query = "select * from nation";
			PreparedStatement p = con.prepareStatement(query);

			ResultSet r = p.executeQuery();

			while(r.next()){
				Nation nation1 = new Nation();
				nation1.nationId = r.getInt(1);
				nation1.nation = r.getString(2);
				nations.add(nation1);
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
		return nations;
	}

	//------------------------GETTER-SETTER-------------
	public void setNation(String nation){
		this.nation = nation;
	}

	public String getNation(){
		return nation;
	}
	public void setNationId(Integer nationId){
		this.nationId = nationId;
	}
	public Integer getNationId(){
		return nationId;
	}
}