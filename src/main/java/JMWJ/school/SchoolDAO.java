package JMWJ.school;

import java.io.IOException;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.ibatis.session.SqlSession;

import JMWJ.BanJi.BanJiBean;
import JMWJ.common.DB.MBSessionFactory;

public class SchoolDAO {
	private SqlSession session = null;

	private SqlSession getSqlSession() throws ConfigurationException,
			IOException {
		SqlSession sqlSession = MBSessionFactory.instance()
				.getSqlSessionFactory().openSession();
		return sqlSession;
	}
	
	@SuppressWarnings("finally")
	public List<SchoolBean> getAllSchool() throws ConfigurationException,
			IOException {
		List<SchoolBean> listSchool = null;
		try {
			session = getSqlSession();
			listSchool = session.selectList("getAllSchool");
			session.commit();

		} catch (ConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (session != null) {
				session.close();
			}
			return listSchool;
		}
	}
}
