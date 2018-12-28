package cn.eugene.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.eugene.po.User;
import cn.eugene.po.UserCustom;
import cn.eugene.po.UserQueryVo;

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
	

	@Test
	public void testFindUserById2() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//mybatis�Զ����ɽӿ�ʵ����������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById2(1);
		System.out.println(user);
	}
	//�û��ۺ���Ϣ��ѯ
	@Test
	public void testFindUserList() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//mybatis�Զ����ɽӿ�ʵ����������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setUserName("�˷�");
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
	}
	
	    //�����������û�����ѯ
		@Test
		public void testFindUserCount() throws Exception {
			
			SqlSession sqlSession = sqlSessionFactory.openSession();
			//mybatis�Զ����ɽӿ�ʵ����������
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);				
			UserQueryVo userQueryVo = new UserQueryVo();
			UserCustom userCustom = new UserCustom();
			userCustom.setUserName("�˷�");
			userQueryVo.setUserCustom(userCustom);
			List<Integer> ids = new ArrayList<Integer>();
			ids.add(1);
			userQueryVo.setIds(ids);
			int count  = userMapper.findUserCount(userQueryVo);
			System.out.println("count: "+count);
		}

}
