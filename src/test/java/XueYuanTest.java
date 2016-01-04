import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import JMWJ.XueYuan.XueYuanBean;
import JMWJ.XueYuan.XueYuanDAO;

public class XueYuanTest {
//	 @Test
	public void saveXueYuan() throws ParseException {
		XueYuanBean xueyuan = new XueYuanBean();
		xueyuan.setName("杨奕");
		xueyuan.setSex("女");
		xueyuan.setDegree("小学");
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		xueyuan.setBirthday(dateFormat.parse("2008-11-21"));
		xueyuan.setStartday(dateFormat.parse("2015-04-05"));
		xueyuan.setChannel("宣传海报");
		xueyuan.setMothername("张敏");
		xueyuan.setMothermobile("139XXXXXXX");
		xueyuan.setGivehours(40);
		xueyuan.setClassesid("3");
		XueYuanDAO xueyuanDao = new XueYuanDAO();
		xueyuanDao.createXueYuan(xueyuan);
	}
	
	@Test
	public void modifyXueYuan() throws ParseException {
		XueYuanBean xueyuan = new XueYuanBean();
		xueyuan.setId(3);
		xueyuan.setMothername("李华");
		xueyuan.setMothermobile("137XXXXXXX");
		xueyuan.setGivehours(80);
		xueyuan.setClassesid("2");
		XueYuanDAO xueyuanDao = new XueYuanDAO();
		xueyuanDao.modifyXueYuan(xueyuan);
	}

	// @Test
	public void getXueYuanByName() throws ParseException {
		XueYuanDAO xueyuanDao = new XueYuanDAO();
		List<XueYuanBean> listXueYuan = xueyuanDao.getXueYuanByName("彤");
		System.out.println("*********listXueYuan getXueYuanByName************ "
				+ listXueYuan.get(0).getDegree());
	}

	// @Test
	public void getXueYuanByClassID() throws ParseException {
		XueYuanDAO xueyuanDao = new XueYuanDAO();

		List<XueYuanBean> listXueYuan = xueyuanDao.getXueYuanByClassID("1");
		Iterator<XueYuanBean> iterator = listXueYuan.iterator();
		while (iterator.hasNext()) {
			System.out
					.println("*********listXueYuan getXueYuanByClassID************ "
							+ iterator.next().getClassesid());
		}
	}

	@SuppressWarnings("unchecked")
//	@Test
	public void getAllXueYuan() throws ParseException {
		XueYuanDAO xueyuanDao = new XueYuanDAO();

		List<XueYuanBean> listXueYuan = xueyuanDao.getAllXueYuan();
		Iterator<XueYuanBean> iterator = listXueYuan.iterator();
		while (iterator.hasNext()) {
			System.out
					.println("*********listXueYuan getAllXueYuan************ "
							+ iterator.next().getClassesid());
		}
	}

}
