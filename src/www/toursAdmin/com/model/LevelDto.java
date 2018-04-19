package www.toursAdmin.com.model;

public class LevelDto {
	private int total_likecount;
	private String target_user_name;
	private int target_user_seq;
	private int status;
	
	public LevelDto() {
		// TODO Auto-generated constructor stub
	}

	
	
	public LevelDto(int total_likecount, String target_user_name, int target_user_seq, int status) {
		super();
		this.total_likecount = total_likecount;
		this.target_user_name = target_user_name;
		this.target_user_seq = target_user_seq;
		this.status = status;
	}



	public int getTotal_likecount() {
		return total_likecount;
	}

	public void setTotal_likecount(int total_likecount) {
		this.total_likecount = total_likecount;
	}

	public String getTarget_user_name() {
		return target_user_name;
	}

	public void setTarget_user_name(String target_user_name) {
		this.target_user_name = target_user_name;
	}

	public int getTarget_user_seq() {
		return target_user_seq;
	}

	public void setTarget_user_seq(int target_user_seq) {
		this.target_user_seq = target_user_seq;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "LevelDto [total_likecount=" + total_likecount + ", target_user_name=" + target_user_name
				+ ", target_user_seq=" + target_user_seq + ", status=" + status + "]";
	}
		
	
}
