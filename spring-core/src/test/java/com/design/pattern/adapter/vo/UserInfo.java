package com.design.pattern.adapter.vo;

/**
 * @ClassName UserInfo
 * @Description 用户信息
 * @Author Jacob
 * @Version 1.0
 * @since 2020/4/14 15:50
 **/
public class UserInfo {

	private String userName;

	private String password;

	public UserInfo(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "{\"username\":" + userName + ";\"password\":" + password + ";}";
	}
}
