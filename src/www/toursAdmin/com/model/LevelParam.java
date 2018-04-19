package www.toursAdmin.com.model;

public class LevelParam {

	private int seq;
	private int status;
	
	public LevelParam(int seq, int status) {
		this.seq = seq;
		this.status = status;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LevelParam [seq=" + seq + ", status=" + status + "]";
	}
	
	
}


