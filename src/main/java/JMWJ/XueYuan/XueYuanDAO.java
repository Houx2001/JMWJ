package JMWJ.XueYuan;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.ibatis.session.SqlSession;

import JMWJ.common.DB.MBSessionFactory;

public class XueYuanDAO {
	private SqlSession session = null;

	private SqlSession getSqlSession() throws ConfigurationException,
			IOException {
		SqlSession sqlSession = MBSessionFactory.instance()
				.getSqlSessionFactory().openSession();
		return sqlSession;
	}

	@SuppressWarnings("finally")
	public List<XueYuanBean> getAllXueYuan() throws ConfigurationException,
			IOException {
		List<XueYuanBean> listXueYuan = null;
		try {
			session = getSqlSession();
			listXueYuan = session.selectList("getAllXueYuan");
			session.commit();

		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
			return listXueYuan;
		}
	}
	
	@SuppressWarnings("finally")
	public List<XueYuanBean> getAllXueYuanBySchool(String school) throws ConfigurationException,
			IOException {
		List<XueYuanBean> listXueYuan = null;
		try {
			session = getSqlSession();
			listXueYuan = session.selectList("getAllXueYuanBySchool", school);
			session.commit();

		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
			return listXueYuan;
		}
	}

	@SuppressWarnings("finally")
	public List<XueYuanBean> getXueYuanByClassID(String classID)
			throws ConfigurationException, IOException {
		List<XueYuanBean> listXueYuan = null;
		try {
			session = getSqlSession();
			listXueYuan = session.selectList("getXueYuanByClassID", classID);
			session.commit();

		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
			return listXueYuan;
		}
	}

	@SuppressWarnings("finally")
	public List<XueYuanBean> getXueYuanByClassIDAndSchool(Map map)
			throws ConfigurationException, IOException {
		List<XueYuanBean> listXueYuan = null;
		try {
			session = getSqlSession();
			listXueYuan = session.selectList("getXueYuanByClassIDAndSchool", map);
			session.commit();

		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
			return listXueYuan;
		}
	}

	
	@SuppressWarnings("finally")
	public List<XueYuanBean> getXueYuanByName(String name)
			throws ConfigurationException, IOException {

		List<XueYuanBean> listXueYuan = null;
		try {
			session = getSqlSession();
			listXueYuan = session.selectList("model.XueYuan.getXueYuanByName",
					name);
			session.commit();

		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
			return listXueYuan;
		}
	}
	
	@SuppressWarnings("finally")
	public List<XueYuanBean> getXueYuanByNameAndSchool(Map map)
			throws ConfigurationException, IOException {

		List<XueYuanBean> listXueYuan = null;
		try {
			session = getSqlSession();
			listXueYuan = session.selectList("model.XueYuan.getXueYuanByNameAndSchool",
					map		);
			session.commit();

		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
			return listXueYuan;
		}
	}

	public void createXueYuan(XueYuanBean xueyuan)
			throws ConfigurationException, IOException {
		SqlSession session = null;

		try {
			session = getSqlSession();
			session.insert("createXueYuan", xueyuan);
			session.commit();
		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	public void modifyXueYuan(XueYuanBean xueyuan)
			throws ConfigurationException, IOException {
		SqlSession session = null;

		try {
			session = getSqlSession();
			session.update("modifyXueYuan", xueyuan);
			session.commit();
		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

	public void removeXueYuan(int xueyuanID) throws ConfigurationException,
			IOException {
		SqlSession session = null;

		try {
			session = getSqlSession();
			session.update("removeXueYuan", xueyuanID);
			session.commit();
		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}

		}
	}

}
