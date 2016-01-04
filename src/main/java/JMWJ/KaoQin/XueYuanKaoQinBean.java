package JMWJ.KaoQin;

import java.util.Date;

public class XueYuanKaoQinBean {
	private int id;
	private int studentid;
	private String studentname;
	private String classname;
	private Date timesheettime;
	private String status;
	private int rating;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Date getTimesheettime() {
		return timesheettime;
	}

	public void setTimesheettime(Date timesheettime) {
		this.timesheettime = timesheettime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
		
}
