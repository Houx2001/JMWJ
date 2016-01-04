import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import JMWJ.BanJi.BanJiBean;
import JMWJ.BanJi.BanJiDAO;


public class BanJiTest {
//	@Test
	public void saveBanJi() throws ParseException {
		BanJiBean banji = new BanJiBean();
		banji.setName("杨奕");
		banji.setStudytype("周一和周五晚5:30");
		banji.setPayhour(1.5);
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		banji.setStarttime(dateFormat.parse("2015-04-11"));
		banji.setPay(80);
		banji.setTeachers("刘昱含");
		BanJiDAO banjiDao = new BanJiDAO();
		banjiDao.createBanJi(banji);
	}
	
	@Test
	public void modifyBanJi() throws ParseException {
		BanJiBean banji = new BanJiBean();
		banji.setId(1);
		banji.setName("大1班");
		BanJiDAO banjiDao = new BanJiDAO();
		banjiDao.modifyBanji(banji);
	}
}
