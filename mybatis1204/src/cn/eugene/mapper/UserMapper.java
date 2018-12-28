package cn.eugene.mapper;

import java.util.List;

import cn.eugene.po.User;
import cn.eugene.po.UserCustom;
import cn.eugene.po.UserQueryVo;

public interface UserMapper {
	
	public  User findUserById(int id) throws Exception;
	
	public void deleteUser(int id) throws Exception;
	
	public void updateUser(User user) throws Exception;
	
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	public int findUserCount(UserQueryVo userQueryVo) throws Exception;
	
	public User findUserById2(int id) throws Exception;

}
