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
		//得到配置文件流
		String resource = "SqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//通过会话工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", "1");
		System.out.println(user);
		sqlSession.close();		
	}
	
	
    @Test
    public void insertUser() throws IOException {
    	String resource = "SqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//通过会话工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		User user = new User();
		user.setUserName("出运费");
		user.setUserAge("21");
		user.setUserAddress("重庆2");
		sqlSession.update("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
    }
    @Test
    public void deleteUser() throws IOException {
    	String resource = "SqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//通过会话工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		sqlSession.delete("test.deleteUser", "2");
		sqlSession.commit();
		sqlSession.close();
    }
    
    @Test
    public void updateUser() throws IOException {
    	String resource = "SqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		//创建会话工厂，传入mybatis的配置文件信息
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		//通过会话工厂得到SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();	
		User user = new User();
		user.setId(2);
		user.setUserName("出运费");
		user.setUserAge("21");
		user.setUserAddress("重庆");
		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
    }
    
    

}
