package JMWJ.view.managedbean;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.configuration.ConfigurationException;
import org.primefaces.event.RowEditEvent;

import JMWJ.BanJi.BanJiBean;
import JMWJ.BanJi.BanJiDAO;
import JMWJ.KaoQin.XueYuanKaoQinBean;

@ManagedBean(name = "banjiManagmentBean")
@ViewScoped
public class BanJiManagmentAction {

	private BanJiDAO banjiDao = new BanJiDAO();
	private final String SAVE_MSG = "数据保存成功";
	private final String ERROR_MSG = "操作出现异常，请联系管理员";

	public void save(ActionEvent ev) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		BanJiBean banji = (BanJiBean) req.getAttribute("banjiBean");
		banji.setSchool(session.getAttribute("school").toString());
		try {
			banjiDao.createBanJi(banji);
			facesContext.addMessage("saveBanJi", new FacesMessage(
					FacesMessage.SEVERITY_INFO, SAVE_MSG, null));

		} catch (Exception e) {
			e.printStackTrace();
			facesContext.addMessage("saveBanJi", new FacesMessage(
					FacesMessage.SEVERITY_ERROR, ERROR_MSG, e.toString()));
		}
	}

	public List<BanJiBean> getBanjiList() throws ConfigurationException,
			IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext()
				.getSession(true);
		return banjiDao.getAllBanjiBySchool(session.getAttribute("school")
				.toString());
	}

	public void changeBanji(RowEditEvent ev) throws ConfigurationException,
			IOException {
		BanJiBean banjiBean = (BanJiBean) ev.getObject();
		banjiDao.modifyBanji(banjiBean);
	}
}
