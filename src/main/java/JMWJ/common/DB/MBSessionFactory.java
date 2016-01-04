package JMWJ.common.DB;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MBSessionFactory {
	
	private static final String APP_CONFIG_PATH = "JMWJ/AppConfig.properties"; 
	
	private static SqlSessionFactory sqlSessionFactory;
	
	private MBSessionFactory(){
		
	}
	
	private static void init() throws IOException, ConfigurationException{
		CompositeConfiguration config = new CompositeConfiguration();
	    config.addConfiguration(new PropertiesConfiguration(APP_CONFIG_PATH));
		InputStream inputStream = Resources.getResourceAsStream(config.getString("mybatis.config.xml"));
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	
	}
	
	static public MBSessionFactory instance() throws IOException, ConfigurationException{
		init();
		return new MBSessionFactory();
		
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
}
