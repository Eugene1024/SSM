package cn.eugene.po;

public class User {
    private int id;
	private String userName;
	private String userAge;
	private String userAddress;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userAge
	 */
	public String getUserAge() {
		return userAge;
	}
	/**
	 * @param userAge the userAge to set
	 */
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}
	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userAge=" + userAge + ", userAddress=" + userAddress
				+ "]";
	}	
	

}
