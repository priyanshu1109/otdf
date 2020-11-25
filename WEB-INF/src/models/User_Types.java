package models;

public class User_Types{
	private String userType;
	private Integer userTypeId;

	public User_Types(){
	
	}

	public User_Types(Integer userTypeId){
		this.userTypeId = userTypeId;
	}
	public void setUserType(String userType){
		this.userType = userType;
	}
	public String getUserType(){
		return userType;
	}
	public void setUserTypeId(Integer userTypeId){
		this.userTypeId = userTypeId;
	}
	public Integer getUserTypeId(){
		return userTypeId;
	}
}