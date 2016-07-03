package JMWJ.BanJi;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="banjiBean")
@RequestScoped
public class BanJiBean {
	private int id; // 鐝骇缂栧彿
	private String name; // 鐝骇鍚嶇О
	private Date starttime; // 寮�鐝椂闂�
	private String studytype; // 涓婅鏃堕棿
	private double payhour; // 璇炬椂
	private int pay; // 璇炬椂璐�
	private String teachers; // 鎺堣鏁欏笀
	private String school; // 淇濈暀瀛楁1
	private String extend2; // 淇濈暀瀛楁2

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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

}
