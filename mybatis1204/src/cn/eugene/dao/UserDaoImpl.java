package cn.eugene.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.eugene.po.User;

public class UserDaoImpl implements UserDao {

	//通过dao向实现类中注入SqlSessionFactory
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory =sqlSessionFactory;
	}
	@Override
	public User selectUserById(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行查询操作
		User user = sqlSession.selectOne("test.findUserById",id);
		//释放资源
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行插入操作
	    sqlSession.insert("test.insertUser",user);
	    //提交代码
		sqlSession.commit();
		//释放资源
		sqlSession.close();
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行删除操作
	    sqlSession.delete("test.updateUser",id);
	    //提交代码
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}

}
