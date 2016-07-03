package JMWJ.KaoQin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.ibatis.session.SqlSession;

import JMWJ.common.DB.MBSessionFactory;

public class XueYuanKaoQinDAO {
	private SqlSession session = null;

	private SqlSession getSqlSession() throws ConfigurationException,
			IOException {
		SqlSession sqlSession = MBSessionFactory.instance()
				.getSqlSessionFactory().openSession();
		return sqlSession;
	}

	@SuppressWarnings("finally")
	public List<XueYuanKaoQinBean> getXueYuanKaoQinByBanji(Map queryMap) {
		List<XueYuanKaoQinBean> listKaoQin = null;
		try {
			session = getSqlSession();
			listKaoQin = session
					.selectList("getXueYuanKaoQinByBanji", queryMap);
			session.commit();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			return listKaoQin;
		}
	}

	@SuppressWarnings("finally")
	public List<XueYuanKaoQinBean> getXueYuanKaoQinByXueYuan(String studentName) {

		List<XueYuanKaoQinBean> listKaoQin = null;
		try {
			session = getSqlSession();
			listKaoQin = session.selectList("getXueYuanKaoQinByXueYuan",
					studentName);
			session.commit();

		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			return listKaoQin;
		}
	}

	@SuppressWarnings({ "finally", "rawtypes" })
	public List<XueYuanKaoQinBean> getXueYuanKaoQinByBanJiAndShiJian(
			Map queryKaoQin) {

		List<XueYuanKaoQinBean> listKaoQin = null;
		try {
			session = getSqlSession();
			listKaoQin = session.selectList(
					"getXueYuanKaoQinByBanJiAndShiJian", queryKaoQin);
			session.commit();

		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			return listKaoQin;
		}
	}

	@SuppressWarnings({ "finally", "rawtypes" })
	public List<XueYuanKaoQinBean> getXueYuanKaoQinByXueYuanAndZhuangTai(
			Map queryKaoQin) {

		List<XueYuanKaoQinBean> listKaoQin = null;
		try {
			session = getSqlSession();
			listKaoQin = session.selectList(
					"getXueYuanKaoQinByXueYuanAndZhuangTai", queryKaoQin);
			session.commit();

		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			return listKaoQin;
		}
	}

	@SuppressWarnings("finally")
	public List<XueYuanKaoQinBean> getXueYuanKaoQinByXueYuanAndXueqi(
			Map queryKaoQin) {

		List<XueYuanKaoQinBean> listKaoQin = null;
		try {
			session = getSqlSession();
			listKaoQin = session.selectList(
					"getXueYuanKaoQinByXueYuanAndXueqi", queryKaoQin);
			session.commit();

		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			return listKaoQin;
		}
	}

	public void createXueYuanKaoQin(XueYuanKaoQinBean kaoqin) {
		SqlSession session = null;

		try {
			session = getSqlSession();
			session.insert("createXueYuanKaoQin", kaoqin);
			session.commit();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	public void modifyXueYuanKaoQin(XueYuanKaoQinBean kaoqin) {
		SqlSession session = null;

		try {
			session = getSqlSession();
			session.update("modifyXueYuanKaoQin", kaoqin);
			session.commit();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	public void removeKaoQinByBanJi(String className) {
		SqlSession session = null;

		try {
			session = getSqlSession();
			session.delete("removeKaoQinByBanJi", className);
			session.commit();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	public void removeKaoQinById(int id) {
		SqlSession session = null;

		try {
			session = getSqlSession();
			session.delete("removeKaoQinById", id);
			session.commit();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	@SuppressWarnings("finally")
	public List<Map> totalXueYuanKaoQinHours(String studentName) {
		List<Map> totalList = null;
		try {
			session = getSqlSession();
			totalList = session.selectList(
					"totalXueYuanKaoQinHoursGroupByStatus", studentName);
			session.commit();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return totalList;
	}

	@SuppressWarnings("finally")
	public List<Map> totalXueYuanKaoQinXueqiHours(Map queryKaoqin) {
		List<Map> totalList = null;
		try {
			session = getSqlSession();
			totalList = session.selectList(
					"totalXueYuanKaoQinXueqiHoursGroupByStatus", queryKaoqin);
			session.commit();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return totalList;
	}
}
