package com.ryan.shopper.shopperserv.dto;

public class UserDTO {
	private Integer userId;
	private String userName;
	private String password;
	public UserDTO(Integer id, String name, String password) {
		this.userId = id;
		this.userName = name;
		this.password = password;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	public void setPassword(String pw) {
		this.password = pw;
	}
	public Integer getUserId() {
		return this.userId;
	}
	public String getUserName() {
		return this.userName;
	}
	public String getPassword() {
		return this.password;
	}
}
