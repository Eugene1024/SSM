package cn.eugene.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.eugene.po.User;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception{
		
	    //����sqlSessionFactory
		String resource = "SqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//�����Ự����������mybatis�������ļ���Ϣ
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);		
	}

	@Test
	public void testFindUserById() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//mybatis�Զ����ɽӿ�ʵ����������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}

}
