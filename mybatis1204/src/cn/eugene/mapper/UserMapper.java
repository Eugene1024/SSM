package cn.eugene.mapper;

import cn.eugene.po.User;

public interface UserMapper {
	
	public  User findUserById(int id) throws Exception;
	
	public void deleteUser(int id) throws Exception;
	
	public void updateUser(User user) throws Exception;

}
