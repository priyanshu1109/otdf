package models;

public class PostType{
	private Integer postTypeId;
	private String postType;
	
	public static final PostType QUESTION = new PostType(1,"Question");
	public static final PostType REPLY = new PostType(2,"Reply");

	//Constructor
	public PostType(){
	
	}

	public PostType(Integer postTypeId,String postType){
		this.postTypeId = postTypeId;
		this.postType = postType;
	}
	//Setter-Getter

	public void setPostTypeId(Integer postTypeId){
		this.postTypeId = postTypeId;
	}

	public Integer getPostTypeId(){
		return postTypeId;
	}
	public void setPostType(String postType){
		this.postType = postType;
	}
	public String getPostType(){
		return postType;
	}
}