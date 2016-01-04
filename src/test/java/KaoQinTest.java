import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import JMWJ.KaoQin.XueYuanKaoQinBean;
import JMWJ.KaoQin.XueYuanKaoQinDAO;

public class KaoQinTest {

	// @Test
	public void saveXueYuanKaoQin() throws ParseException {
		XueYuanKaoQinBean kaoqin = new XueYuanKaoQinBean();
		kaoqin.setStudentid(2);
		kaoqin.setClassname("");
		kaoqin.setStatus("上课");
		kaoqin.setTimesheettime(new Date());
		kaoqin.setRating(5);

		XueYuanKaoQinDAO xueyuankaoqinDao = new XueYuanKaoQinDAO();
		xueyuankaoqinDao.createXueYuanKaoQin(kaoqin);
	}

	@SuppressWarnings("unchecked")
	// @Test
	public void getXueYuanKaoQinByBanji() throws ParseException {
		XueYuanKaoQinDAO xueyuankaoqinDao = new XueYuanKaoQinDAO();
		List<XueYuanKaoQinBean> listXueYuanKaoQin = xueyuankaoqinDao
				.getXueYuanKaoQinByBanji("");
		System.out.println("=============" + listXueYuanKaoQin.size());
		for (XueYuanKaoQinBean xueyuankaoqin : listXueYuanKaoQin) {
			System.out
					.println("*********listXueYuanKaoQin getXueYuanKaoQinByBanji************ "
							+ xueyuankaoqin.getStudentname()
							+ xueyuankaoqin.getTimesheettime());
		}
	}

	@SuppressWarnings("unchecked")
	// @Test
	public void getXueYuanKaoQinByXueYuan() throws ParseException {
		XueYuanKaoQinDAO xueyuankaoqinDao = new XueYuanKaoQinDAO();
		List<XueYuanKaoQinBean> listXueYuanKaoQin = xueyuankaoqinDao
				.getXueYuanKaoQinByXueYuan(2);
		System.out.println("=============" + listXueYuanKaoQin.size());
		for (XueYuanKaoQinBean xueyuankaoqin : listXueYuanKaoQin) {
			System.out
					.println("*********listXueYuanKaoQin getXueYuanKaoQinByXueYuan************ "
							+ xueyuankaoqin.getStudentname()
							+ xueyuankaoqin.getTimesheettime());
		}
	}

	@Test
	public void getXueYuanKaoQinByBanJiAndShiJian() throws ParseException {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("classid", 1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		queryMap.put("timesheettime", dateFormat.parse("2015-11-24"));
		
		XueYuanKaoQinDAO xueyuankaoqinDao = new XueYuanKaoQinDAO();
		List<XueYuanKaoQinBean> listXueYuanKaoQin = xueyuankaoqinDao
				.getXueYuanKaoQinByBanJiAndShiJian(queryMap);
		System.out.println("=======queryMap======" + queryMap);
		System.out.println("=============" + listXueYuanKaoQin.size());
		for (XueYuanKaoQinBean xueyuankaoqin : listXueYuanKaoQin) {
			System.out
					.println("*********listXueYuanKaoQin getXueYuanKaoQinByBanJiAndShiJian************ "
							+ xueyuankaoqin.getStudentname()
							+ xueyuankaoqin.getTimesheettime());
		}
	}
}
