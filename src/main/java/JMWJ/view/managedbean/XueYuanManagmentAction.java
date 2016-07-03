package JMWJ.view.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.configuration.ConfigurationException;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;

import JMWJ.BanJi.BanJiDAO;
import JMWJ.XueYuan.XueYuanBean;
import JMWJ.XueYuan.XueYuanDAO;

@ManagedBean(name = "xueyuanManagmentBean")
@ViewScoped
public class XueYuanManagmentAction implements Serializable {

	private XueYuanDAO xueyuanDao = new XueYuanDAO();
	private BanJiDAO banjiDao = new BanJiDAO();
	private final String SAVE_MSG = "数据保存成功";
	private final String ERROR_MSG = "操作出现异常，请联系管理员";
	private int activeIndex = 0;
	private List<XueYuanBean> xueyuanQueryList;

	public void save(ActionEvent ev) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		XueYuanBean xueyuan = (XueYuanBean) req.getAttribute("xueyuanBean");
		xueyuan.setSchool(session.getAttribute("school").toString());
		try {
			xueyuanDao.createXueYuan(xueyuan);
			facesContext.addMessage("saveXueYuan", new FacesMessage(
					FacesMessage.SEVERITY_INFO, SAVE_MSG, null));

		} catch (Exception e) {
			e.printStackTrace();
			facesContext.addMessage("saveXueYuan", new FacesMessage(
					FacesMessage.SEVERITY_ERROR, ERROR_MSG, e.toString()));
		}
	}

	public void querybyclassid(ActionEvent ev) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		XueYuanBean xueyuan = (XueYuanBean) req.getAttribute("xueyuanBean");
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		Map<String, String> map = new HashMap();
		map.put("classesid", xueyuan.getClassesid());
		map.put("school", session.getAttribute("school").toString());
		try {
			xueyuanQueryList = xueyuanDao.getXueYuanByClassIDAndSchool(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<XueYuanBean> getXueyuanList() throws ConfigurationException,
			IOException {
		if (this.xueyuanQueryList == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext
					.getExternalContext().getSession(true);
			this.xueyuanQueryList = xueyuanDao.getAllXueYuanBySchool(session
					.getAttribute("school").toString());
		}
		return this.xueyuanQueryList;
	}

	public void setXueyuanList(List<XueYuanBean> xueyuanQueryList) {
		this.xueyuanQueryList = xueyuanQueryList;
	}

	public List<XueYuanBean> queryByXueyuanName(String name)
			throws ConfigurationException, IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		Map<String, String> map = new HashMap();
		map.put("name", name);
		map.put("school", session.getAttribute("school").toString());
		return xueyuanDao.getXueYuanByNameAndSchool(map);
	}

	public int getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
	}

	public List<XueYuanBean> getXueyuanQueryList() {
		return xueyuanQueryList;
	}

	public void setXueyuanQueryList(List<XueYuanBean> xueyuanQueryList) {
		this.xueyuanQueryList = xueyuanQueryList;
	}

	public void update(RowEditEvent ev) throws ConfigurationException,
			IOException {
		XueYuanBean xueyuanBean = (XueYuanBean) ev.getObject();
		xueyuanDao.modifyXueYuan(xueyuanBean);
	}
}