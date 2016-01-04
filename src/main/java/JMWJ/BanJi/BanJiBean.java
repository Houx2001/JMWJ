package JMWJ.BanJi;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="banjiBean")
@RequestScoped
public class BanJiBean {
	private int id; // 班级编号
	private String name; // 班级名称
	private Date starttime; // 开班时间
	private String studytype; // 上课时间
	private double payhour; // 课时
	private int pay; // 课时费
	private String teachers; // 授课教师
	private String extend1; // 保留字段1
	private String extend2; // 保留字段2

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public String getStudytype() {
		return studytype;
	}

	public void setStudytype(String studytype) {
		this.studytype = studytype;
	}

	public double getPayhour() {
		return payhour;
	}

	public void setPayhour(double payhour) {
		this.payhour = payhour;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public String getTeachers() {
		return teachers;
	}

	public void setTeachers(String teachers) {
		this.teachers = teachers;
	}

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

}
