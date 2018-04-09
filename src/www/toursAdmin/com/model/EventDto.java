package www.toursAdmin.com.model;

import java.io.Serializable;

public class EventDto implements Serializable {
	private int seq;
	private String category;
	private String title;
	private String content;
	private String from_date;
	private String to_date;
	private String last_updated;
	private String reg_date;
	private int status;
	
	public EventDto() {
		// TODO Auto-generated constructor stub
	}

	public EventDto(int seq, String category, String title, String content, String from_date, String to_date,
			String last_updated, String reg_date, int status) {
		super();
		this.seq = seq;
		this.category = category;
		this.title = title;
		this.content = content;
		this.from_date = from_date;
		this.to_date = to_date;
		this.last_updated = last_updated;
		this.reg_date = reg_date;
		this.status = status;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public String getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EventDto [seq=" + seq + ", category=" + category + ", title=" + title + ", content=" + content
				+ ", from_date=" + from_date + ", to_date=" + to_date + ", last_updated=" + last_updated + ", reg_date="
				+ reg_date + ", status=" + status + "]";
	}

	
}
