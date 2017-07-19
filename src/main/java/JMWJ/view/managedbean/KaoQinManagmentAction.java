package JMWJ.view.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.event.RowEditEvent;

import JMWJ.KaoQin.XueYuanKaoQinBean;
import JMWJ.KaoQin.XueYuanKaoQinDAO;
import JMWJ.XueYuan.XueYuanBean;
import JMWJ.XueYuan.XueYuanDAO;

@ManagedBean(name = "kaoqinManagementBean")
@ViewScoped
public class KaoQinManagmentAction {

	private XueYuanKaoQinDAO kaoqinDao = new XueYuanKaoQinDAO();
	private final String SAVE_MSG = "数据保存成功";
	private final String SAVE_MSG_DUPLICATE = "班级当前考勤日期数据已存在，禁止重复录入！";
	private final String ERROR_MSG = "操作出现异常，请联系管理员";

	private String className;
	private JMWJ.XueYuan.XueYuanBean student;
	private String studentName;
	private Date timesheettime = new Date();
	private Date starttime;
	private Date endtime;
	private float classhours = 1;
	private List<XueYuanKaoQinBean> kaoqinQueryList;
	private List<XueYuanKaoQinBean> kaoqinFilteredList;
	private XueYuanKaoQinBean selectedKaoQin;
	private List<XueYuanKaoQinBean> inputKaoQinList = new ArrayList<XueYuanKaoQinBean>();
	private List<Map> totalHours;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public XueYuanBean getStudent() {
		return student;
	}

	public void setStudent(XueYuanBean student) {
		this.student = student;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public float getClasshours() {
		return classhours;
	}

	public void setClasshours(float classhours) {
		this.classhours = classhours;
	}

	public List<XueYuanKaoQinBean> getKaoqinQueryList() {
		return kaoqinQueryList;
	}

	public void setKaoqinQueryList(List<XueYuanKaoQinBean> kaoqinQueryList) {
		this.kaoqinQueryList = kaoqinQueryList;
	}

	public Date getTimesheettime() {
		return timesheettime;
	}

	public void setTimesheettime(Date timesheettime) {
		this.timesheettime = timesheettime;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date startime) {
		this.starttime = startime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public List<XueYuanKaoQinBean> getKaoqinFilteredList() {
		return kaoqinFilteredList;
	}

	public void setKaoqinFilteredList(List<XueYuanKaoQinBean> kaoqinFilteredList) {
		this.kaoqinFilteredList = kaoqinFilteredList;
	}

	public XueYuanKaoQinBean getSelectedKaoQin() {
		return selectedKaoQin;
	}

	public void setSelectedKaoQin(XueYuanKaoQinBean selectedKaoQin) {
		this.selectedKaoQin = selectedKaoQin;
	}

	public List<XueYuanKaoQinBean> getInputKaoQinList() {
		if (inputKaoQinList.size() == 0) {
			inputKaoQinList.add(new XueYuanKaoQinBean());
		}
		return inputKaoQinList;
	}

	public void setInputKaoQinList(List<XueYuanKaoQinBean> inputKaoQinList) {
		this.inputKaoQinList = inputKaoQinList;
	}

	public List<Map> getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(List<Map> totalHours) {
		this.totalHours = totalHours;
	}

	public void save(ActionEvent ev) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext context = facesContext.getExternalContext();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		Map<String, String> reqParams = context.getRequestParameterMap();
		String className = reqParams.get("className");
		Map queryMap = new HashMap();
		queryMap.put("classname", className);
		queryMap.put("timesheettime", timesheettime);
		queryMap.put("school", session.getAttribute("school").toString());		
		if (!kaoqinDao.getXueYuanKaoQinByBanJiAndShiJian(queryMap).isEmpty()) {
			facesContext.addMessage("saveKaoQin", new FacesMessage(
					FacesMessage.SEVERITY_WARN, SAVE_MSG_DUPLICATE, null));
			return;
		}
		Iterator<String> reqNames = context.getRequestParameterNames();
		ArrayList<String> studentId = new ArrayList<String>();
		ArrayList<String> studentName = new ArrayList<String>();
		ArrayList<String> rating = new ArrayList<String>();
		ArrayList<String> studentstatus = new ArrayList<String>();
		while (reqNames.hasNext()) {
			String reqName = reqNames.next();
			if (reqName.indexOf("studentId") != -1) {
				studentId.add(reqParams.get(reqName));
			}
			if (reqName.indexOf("studentName") != -1) {
				studentName.add(reqParams.get(reqName));
			}
			if (reqName.indexOf("studentstatus_input") != -1) {
				studentstatus.add(reqParams.get(reqName));
			}
			if (reqName.indexOf("studentrating_input") != -1) {
				rating.add((reqParams.get(reqName).equals("") ? "0" : reqParams
						.get(reqName)));
			}

		}

		if (studentId != null && studentId.size() != 0) {
			for (int i = 0; i < studentId.size(); i++) {
				XueYuanKaoQinBean kaoqinBean = new XueYuanKaoQinBean();
				if (studentstatus.get(i).trim().equals("空白")) {
					continue;
				}
				kaoqinBean.setStudentid(Integer.parseInt(studentId.get(i)));
				kaoqinBean.setClassname(reqParams.get("className"));
				kaoqinBean.setTimesheettime(timesheettime);
				kaoqinBean.setStatus(studentstatus.get(i));
				kaoqinBean.setRating(Integer.parseInt(rating.get(i)));
				kaoqinBean.setClasshours(classhours);
				try {
					kaoqinDao.createXueYuanKaoQin(kaoqinBean);

				} catch (Exception e) {
					e.printStackTrace();
					facesContext.addMessage("saveKaoQin",
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									ERROR_MSG, e.toString()));
					return;
				}

			}
			facesContext.addMessage("saveKaoQin", new FacesMessage(
					FacesMessage.SEVERITY_INFO, SAVE_MSG, null));
		}
	}

	public void querybyclassname(ActionEvent ev) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		Map queryKaoqin = new HashMap();
		queryKaoqin.put("classname", className);
		queryKaoqin.put("school", session.getAttribute("school").toString());
		kaoqinQueryList = kaoqinDao.getXueYuanKaoQinByBanji(queryKaoqin);
	}

	public void querybystudentname(ActionEvent ev) {

		kaoqinQueryList = kaoqinDao.getXueYuanKaoQinByXueYuan(studentName);
		totalHours = kaoqinDao.totalXueYuanKaoQinHours(studentName);
	}

	public void queryByStudentNameAndXueqi(ActionEvent ev) throws Exception,
			IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		Map queryXueyuan = new HashMap();
		queryXueyuan.put("name", studentName);
		queryXueyuan.put("school", session.getAttribute("school").toString());
		XueYuanDAO xueyuanDao = new XueYuanDAO();
		List xueyuanList = xueyuanDao.getXueYuanByNameAndSchool(queryXueyuan);
		XueYuanBean xueyuan = (XueYuanBean) xueyuanList.get(0);
		Map queryKaoqin = new HashMap();
		queryKaoqin.put("studentname", studentName);
		queryKaoqin.put("starttime", xueyuan.getStartday());
		queryKaoqin.put("endtime", new Date());
		kaoqinQueryList = kaoqinDao
				.getXueYuanKaoQinByXueYuanAndXueqi(queryKaoqin);
		totalHours = kaoqinDao.totalXueYuanKaoQinXueqiHours(queryKaoqin);
	}

	public void changeStatus(RowEditEvent ev) {
		XueYuanKaoQinBean kaoqinBean = (XueYuanKaoQinBean) ev.getObject();
		if (kaoqinBean.getStatus().trim().equals("空白")) {
			kaoqinDao.removeKaoQinById(kaoqinBean.getId());
			return;
		}
		kaoqinDao.modifyXueYuanKaoQin(kaoqinBean);
	}

	public void add(ActionEvent ev) {
		XueYuanKaoQinBean kaoqin = inputKaoQinList.get(0);
		inputKaoQinList.add(new XueYuanKaoQinBean());
	}

	public void additionsave(ActionEvent ev) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (inputKaoQinList != null && inputKaoQinList.size() != 0) {
			for (int i = 0; i < inputKaoQinList.size(); i++) {
				XueYuanKaoQinBean kaoqinBean = inputKaoQinList.get(i);
				if (kaoqinBean.getStatus().trim().equals("空白")) {
					continue;
				}
				kaoqinBean.setTimesheettime(timesheettime);
				try {
					kaoqinDao.createXueYuanKaoQin(kaoqinBean);

				} catch (Exception e) {
					e.printStackTrace();
					facesContext.addMessage("additionsaveKaoQin",
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "第"
									+ i + 1 + "条" + ERROR_MSG, e.toString()));
				}
			}
			inputKaoQinList.clear();
			facesContext.addMessage("additionsaveKaoQin", new FacesMessage(
					FacesMessage.SEVERITY_INFO, SAVE_MSG, null));
		}
	}
}
