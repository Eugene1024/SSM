package cn.eugene.dao;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.eugene.po.User;

public class UserDaoImplTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception{
		
	    //创建sqlSessionFactory
		String resource = "SqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		
	}

	@Test
	public void testSelectUserById() {
		
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		User user = userDao.selectUserById(1);
		System.out.println(user);
		
	}

}
