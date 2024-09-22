package com.ryan.shopper.shopperserv.dto;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AccountCreationDTO {
	@NotNull(message="USERNAME_NULL")
	@Size(min = 8, max = 30, message="USERNAME_SIZE_VIOLATION")
	private String username; 
	@NotNull(message="PASSWORD_NULL")
	@Size(min = 8, max = 30, message="PASSWORD_SIZE_VIOLATION")
	private String password; 
	@NotNull(message="FIRSTNAME_NULL")
	@Size(min = 1, max = 30, message="FIRSTNAME_SIZE_VIOLATION")
	private String firstname;
	@NotNull(message="LASTNAME_NULL")
	@Size(min = 1, max = 30, message="LASTNAME_SIZE_VIOLATION")
	private String lastName;
	@NotNull(message="EMAIL_NULL")
	@Email(message="EMAIL_INVALID")
	private String email;
	@Size(max = 14, message="PHONENUMBER_SIZE_VIOLATION")
	private String phonenumber;
	@NotNull(message="BIRTHDAY_NULL")
	@Size(min = 10, max = 10, message="BIRTHDAY_SIZE_VIOLATION")
	private Date birthday;
	public AccountCreationDTO() {
		
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstName) {
		this.firstname = firstName;
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
	public String getOptionalPhone() {
		return phonenumber;
	}
	public void setOptionalPhone(String optionalPhone) {
		this.phonenumber = optionalPhone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public UserDTO toUserDTO() {
		UserDTO returnDTO = new UserDTO();
		returnDTO.setUserId(0);
		returnDTO.setUserName(this.getUserName());
		returnDTO.setPassword(this.getPassword());
		return returnDTO;
	}
	public UserInfoDTO toUserInfoDTO() {
		UserInfoDTO returnDTO = new UserInfoDTO();
		returnDTO.setUserId(0);
		returnDTO.setFirstName(this.getFirstName());
		returnDTO.setLastName(this.getLastName());
		returnDTO.setEmail(this.getEmail());
		returnDTO.setPhoneNumber(this.getOptionalPhone());
		returnDTO.setBirthday(this.getBirthday());
		returnDTO.setLastLogin(null);
		returnDTO.setCreationDate(new Timestamp(System.currentTimeMillis()));
		
		return returnDTO;
	}
	
}
