package com.ryan.shopper.shopperserv.dto;

import com.ryan.shopper.shopperserv.entity.UserEntity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	@NotNull
	@Min(value=0, message="User ID must be greater than or equal to 0")
	private Integer userId;
	
	@NotNull
	@Size(min=8, max=30, message="Username should be between 8 and 30 characters")
	private String userName;
	
	@NotNull
	@Size(min=8, max=30, message="Password should be between 8 and 30 characters")
	private String password;
	
	public UserDTO() {
		
	}
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
	public UserEntity toEntity() {
		UserEntity returnEntity = new UserEntity();
		returnEntity.setId(this.getUserId());
		returnEntity.setUserName(this.getUserName());
		returnEntity.setPassword(this.getPassword());
		return returnEntity;
	}
}
