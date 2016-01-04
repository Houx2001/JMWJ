package JMWJ.BanJi;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.ibatis.session.SqlSession;

import JMWJ.common.DB.MBSessionFactory;

public class BanJiDAO {
	private SqlSession session = null;

	private SqlSession getSqlSession() throws ConfigurationException,
			IOException {
		SqlSession sqlSession = MBSessionFactory.instance()
				.getSqlSessionFactory().openSession();
		return sqlSession;
	}

	@SuppressWarnings("finally")
	public List<BanJiBean> getAllBanji() throws ConfigurationException,
			IOException {
		List<BanJiBean> listBanJi = null;
		try {
			session = getSqlSession();
			listBanJi = session.selectList("getAllBanJi");
			session.commit();

		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
			return listBanJi;
		}
	}

	@SuppressWarnings("finally")
	public List<BanJiBean> getBanJiByName(String name)
			throws ConfigurationException, IOException {

		List<BanJiBean> listBanJi = null;
		try {
			session = getSqlSession();
			listBanJi = session.selectList("getBanJiByName", name);
			session.commit();

		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
			return listBanJi;
		}
	}

	public void createBanJi(BanJiBean banji) throws ConfigurationException,
			IOException {
		SqlSession session = null;

		try {
			session = getSqlSession();
			session.insert("createBanJi", banji);
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

	public void modifyBanji(BanJiBean banji) throws ConfigurationException,
			IOException {
		SqlSession session = null;

		try {
			session = getSqlSession();
			session.update("modifyBanJi", banji);
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

	public void removeBanJi(int banjiID) throws ConfigurationException,
			IOException {
		SqlSession session = null;

		try {
			session = getSqlSession();
			session.update("removeBanJi", banjiID);
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
