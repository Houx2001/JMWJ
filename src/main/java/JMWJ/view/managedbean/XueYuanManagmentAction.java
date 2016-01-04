package JMWJ.view.managedbean;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.configuration.ConfigurationException;

import JMWJ.BanJi.BanJiBean;
import JMWJ.BanJi.BanJiDAO;
import JMWJ.XueYuan.XueYuanBean;
import JMWJ.XueYuan.XueYuanDAO;

public class XueYuanManagmentAction {

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
		XueYuanBean xueyuan = (XueYuanBean) req.getAttribute("xueyuanBean");
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

	public void querybyclassid() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		XueYuanBean xueyuan = (XueYuanBean) req.getAttribute("xueyuanBean");
		try {
			xueyuanQueryList = xueyuanDao.getXueYuanByClassID(xueyuan
					.getClassesid());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BanJiBean> getBanjiList() throws ConfigurationException,
			IOException {
		return banjiDao.getAllBanji();
	}

	public List<XueYuanBean> getXueyuanList() throws ConfigurationException,
			IOException {
		return xueyuanDao.getAllXueYuan();
	}

	public List<XueYuanBean> queryByXueyuanName(String name) throws ConfigurationException, IOException {
		return xueyuanDao.getXueYuanByName(name);
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

}
