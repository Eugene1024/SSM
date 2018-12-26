package cn.eugene.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.eugene.po.User;

public class UserDaoImpl implements UserDao {

	//ͨ��dao��ʵ������ע��SqlSessionFactory
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
		this.sqlSessionFactory =sqlSessionFactory;
	}
	@Override
	public User selectUserById(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ�в�ѯ����
		User user = sqlSession.selectOne("test.findUserById",id);
		//�ͷ���Դ
		sqlSession.close();
		return user;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ�в������
	    sqlSession.insert("test.insertUser",user);
	    //�ύ����
		sqlSession.commit();
		//�ͷ���Դ
		sqlSession.close();
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//ִ��ɾ������
	    sqlSession.delete("test.updateUser",id);
	    //�ύ����
		sqlSession.commit();
		//�ͷ���Դ
		sqlSession.close();
	}

}
