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
	@NotNull(message="USERID_NULL")
	@Min(value = 0, message="USERID_LESS_THAN_0")
	Integer userId;
	@NotNull(message="FIRSTNAME_NULL")
	@Size(min = 1, max = 30, message="FIRSTNAME_SIZE_VIOLATION")
	String firstName;
	@NotNull(message="LASTNAME_NULL")
	@Size(min = 1, max = 30, message="LASTNAME_SIZE_VIOLATION")
	String lastName;
	@NotNull(message="EMAIL_NULL")
	@Size(min = 5, max = 100, message="EMAIL_SIZE_VIOLATION")
	@Email(message="EMAIL_INVALID")
	String email;
	@Size(max = 14, message="PHONENUMBER_SIZE_VIOLATION")
	String phoneNumber;
	
	@NotNull(message="BIRTHDAY_NULL")
	@Size(min = 10, max = 10, message="BIRTHDAY_SIZE_VOILATION")
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
