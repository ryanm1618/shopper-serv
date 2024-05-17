package com.ryan.shopper.shopperserv.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.ryan.shopper.shopperserv.entity.UserInfoEntity;

public class UserInfoDTO {
	Integer userId;
	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	Timestamp lastLogin;
	Timestamp creationDate;
	
	public UserInfoDTO() {
		
	}
	
	public UserInfoDTO(Integer userId, String firstName, String lastName, String email, String phoneNumber,
			Timestamp lastLogin, Timestamp creationDate) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.lastLogin = lastLogin;
		this.creationDate = creationDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Timestamp getLastLogin() {
		return this.lastLogin;
	}
	public void setLastLogin(Timestamp lastLog) {
		this.lastLogin = lastLog;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public UserInfoEntity toEntity() {
		UserInfoEntity returnEntity = new UserInfoEntity();
		returnEntity.setFirstName(this.getFirstName());
		returnEntity.setLastName(this.getLastName());
		returnEntity.setEmail(this.getEmail());
		returnEntity.setPhone(this.getPhoneNumber());
		returnEntity.setLastLogin(this.getLastLogin());
		returnEntity.setCreationDate(this.getCreationDate());
		
		return returnEntity;
	}
	
}
