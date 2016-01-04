package JMWJ.XueYuan;

import java.util.Date;

public class XueYuanBean {

	private int id;  					//		学员编号									
	private String name;				//		学员姓名
	private String sex;					//      性别
	private String degree;				//		教育类型
	private Date birthday;				//		出生日期
	private Date startday;				//		报名日期
	private String channel;				//		
	private String consultant;			//		咨询师
	private String mobile;				//		本人手机号
	private String phone;				//		本人座机号
	private String mothermobile;		//		母亲手机号
	private String fathermobile;		//		父亲手机号
	private String address;				//		联系地址
	private String mothername;			//		母亲姓名
	private String fathername;			//		父亲姓名
	private int givehours;				//		所报课时
	private String classesid;			//		所在班级
	private String extend1;				//		保留字段1
	private String extend2;				//		保留字段2
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getStartday() {
		return startday;
	}
	public void setStartday(Date startday) {
		this.startday = startday;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getConsultant() {
		return consultant;
	}
	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMothermobile() {
		return mothermobile;
	}
	public void setMothermobile(String mothermobile) {
		this.mothermobile = mothermobile;
	}
	public String getFathermobile() {
		return fathermobile;
	}
	public void setFathermobile(String fathermobile) {
		this.fathermobile = fathermobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public int getGivehours() {
		return givehours;
	}
	public void setGivehours(int givehours) {
		this.givehours = givehours;
	}
	public String getClassesid() {
		
		return this.classesid;
	}
	public void setClassesid(String classesid) {
		this.classesid = classesid;
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
