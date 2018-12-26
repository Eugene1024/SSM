package cn.eugene.dao;

import cn.eugene.po.User;

public interface UserDao {
	
	public User selectUserById(int id);
	public void insertUser(User user);
	public void deleteUser(int id);

}
