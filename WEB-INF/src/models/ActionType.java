package models;

public class ActionType{
	private Integer actionTypeId;
	private String actionType;
	public static final ActionType LIKE = new ActionType(1,"Like");
	public static final ActionType DISLIKE = new ActionType(2,"Dislike");
	public static final ActionType SPAM = new ActionType(3,"Spam");
	
	public ActionType(){
		
	}
	
	public ActionType(Integer actionTypeId,String actionType){
		this.actionTypeId = actionTypeId;
		this.actionType = actionType;
	}
	
	public void setActionTypeId(Integer actionTypeId){
		this.actionTypeId = actionTypeId;
	}

	public Integer getActionTypeId(){
		return actionTypeId;
	}
	public void setActionType(String actionType){
		this.actionType = actionType;
	}
	public String getActionType(){
		return actionType;
	}
}