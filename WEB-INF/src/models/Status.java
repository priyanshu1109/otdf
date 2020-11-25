package models;

public class Status{
	private String status;
	private Integer statusId;

	public Status(){
	
	}

	public Status(Integer statusId,String status){
		this.statusId = statusId;
		this.status = status;
	}


	public Status(Integer statusId){
		this.statusId = statusId;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	}
	public void setStatusId(Integer statusId){
		this.statusId = statusId;
	}
	public Integer getStatusId(){
		return statusId;
	}
}