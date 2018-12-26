package cn.eugene.first;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import cn.eugene.po.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisFirst {
	
	@Test
	public void findUserByIdTest() throws IOException{
		//�õ������ļ���
		String resource = "SqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//�����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//ͨ���Ự�����õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", "1");
		System.out.println(user);
		sqlSession.close();		
	}
	
	
    @Test
    public void insertUser() throws IOException {
    	String resource = "SqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//�����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//ͨ���Ự�����õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		User user = new User();
		user.setUserName("���˷�");
		user.setUserAge("21");
		user.setUserAddress("����2");
		sqlSession.update("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
    }
    @Test
    public void deleteUser() throws IOException {
    	String resource = "SqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//�����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//ͨ���Ự�����õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		sqlSession.delete("test.deleteUser", "2");
		sqlSession.commit();
		sqlSession.close();
    }
    
    @Test
    public void updateUser() throws IOException {
    	String resource = "SqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//�����Ự����������mybatis�������ļ���Ϣ
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//ͨ���Ự�����õ�SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		User user = new User();
		user.setId(2);
		user.setUserName("���˷�");
		user.setUserAge("21");
		user.setUserAddress("����");
		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
    }
    
    

}
