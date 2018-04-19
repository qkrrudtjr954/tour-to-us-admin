package www.toursAdmin.com.model;

import java.io.Serializable;
import java.util.Date;

public class ToditorCategoryDto implements Serializable {

	

	
	private int seq;
	private String title;
	private String description;
	private int status;
	private Date reg_date;
	private Date last_update;
	
	public ToditorCategoryDto() {
		// TODO Auto-generated constructor stub
	}

	public ToditorCategoryDto(int seq, String title, String description, int status, Date reg_date, Date last_update) {
		super();
		this.seq = seq;
		this.title = title;
		this.description = description;
		this.status = status;
		this.reg_date = reg_date;
		this.last_update = last_update;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	@Override
	public String toString() {
		return "ToditorCategoryDto [seq=" + seq + ", title=" + title + ", description=" + description + ", status="
				+ status + ", reg_date=" + reg_date + ", last_update=" + last_update + "]";
	}

	
	
}
