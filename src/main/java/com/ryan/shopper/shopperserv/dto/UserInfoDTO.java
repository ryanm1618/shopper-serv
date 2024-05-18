package com.ryan.shopper.shopperserv.dto;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.ryan.shopper.shopperserv.entity.UserInfoEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserInfoDTO {
	@NotNull
	@Min(value = 0)
	Integer userId;
	@NotNull
	@Size(min = 8, max = 30)
	String firstName;
	@NotNull
	@Size(min = 8, max = 30)
	String lastName;
	@NotNull
	@Size(min = 5, max = 100)
	@Email
	String email;
	@Size(max = 14)
	String phoneNumber;
	
	@NotNull
	@Size(min = 10, max = 10)
	Date birthday;
	
	Timestamp lastLogin;
	Timestamp creationDate;
	
	public UserInfoDTO() {
		
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
	public Date getBirthday() {
		return this.birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
		returnEntity.setBirthday(this.getBirthday());
		returnEntity.setLastLogin(this.getLastLogin());
		returnEntity.setCreationDate(this.getCreationDate());
		
		return returnEntity;
	}
	
}
