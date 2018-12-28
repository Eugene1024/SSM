package cn.eugene.po;

import java.util.List;

public class UserQueryVo {
	private UserCustom userCustom;
	private List<Integer> ids;


	public UserCustom getUserCustom() {
		return userCustom;
	}


	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
    
	

	/**
	 * @return the ids
	 */
	public List<Integer> getIds() {
		return ids;
	}


	/**
	 * @param ids the ids to set
	 */
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}


	@Override
	public String toString() {
		return "UserQueryVo [userCustom=" + userCustom + "]";
	}
	

}
