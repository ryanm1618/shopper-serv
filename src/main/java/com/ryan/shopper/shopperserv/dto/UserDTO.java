package com.ryan.shopper.shopperserv.dto;

import com.ryan.shopper.shopperserv.entity.UserEntity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDTO {
	
	@NotNull(message="USERNAME_NULL")
	@Min(value=0, message="USERID_LESS_THAN_0")
	private Integer userId;
	
	@NotNull(message="USERNAME_NULL")
	@Size(min=8, max=30, message="USERNAME_SIZE_VIOLATION")
	private String userName;
	
	@NotNull(message="PASSWORD_NULL")
	@Size(min=8, max=30, message="PASSWORD_SIZE_VALIDATION")
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
