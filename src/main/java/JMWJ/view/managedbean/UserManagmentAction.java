package JMWJ.view.managedbean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import JMWJ.XueYuan.XueYuanBean;
import JMWJ.school.SchoolBean;
import JMWJ.school.SchoolDAO;

@ManagedBean(name = "userManagmentBean")
@ViewScoped
public class UserManagmentAction {

	private String username;
	private String password;
	private String school;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login() throws IOException {
		Subject currentUser = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		currentUser.login(token);
		if (currentUser.isAuthenticated()) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext context = facesContext.getExternalContext();
			HttpSession session = (HttpSession) context.getSession(true);
			session.setAttribute("school", school);
			facesContext.getExternalContext().redirect("../index.html");
		}
	}

	public List<SchoolBean> getSchoolList() throws ConfigurationException,
			IOException {
		List<SchoolBean> schoolList;
		SchoolDAO schoolDao = new SchoolDAO();
		schoolList = schoolDao.getAllSchool();
		return schoolList;
	}
}
