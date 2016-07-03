package JMWJ.view.managedbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;

import JMWJ.XueYuan.XueYuanBean;
import JMWJ.XueYuan.XueYuanDAO;

@ManagedBean(name = "mobiManagmentBean")
@ViewScoped
public class MobiActionManagment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3249211103558228903L;
	private XueYuanDAO xueyuanDao = new XueYuanDAO();
	
	private List<XueYuanBean> xueyuanQueryList;
	
	public String querybyClassid() {
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
		System.out.println("xueyuanQueryList = " + xueyuanQueryList);
		return "pm:student_list?transition=slide";
	}
	
	public List<XueYuanBean> getXueyuanQueryList() {
		System.out.println("getXueyuanQueryList = " + xueyuanQueryList);
		return xueyuanQueryList;
	}

	public void setXueyuanQueryList(List<XueYuanBean> xueyuanQueryList) {
		this.xueyuanQueryList = xueyuanQueryList;
	}
}