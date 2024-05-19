package com.ryan.shopper.shopperserv.dto;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AccountCreationDTO {
	@NotNull(message="API_DTO - userName can't be null")
	@Size(min = 8, max = 30, message="API_DTO - Invalid userName size")
	private String userName; 
	@NotNull(message="API_DTO - password can't be null")
	@Size(min = 8, max = 30, message="API_DTO - Invalid password length")
	private String password; 
	@NotNull(message="API_DTO - first name can't be null")
	@Size(min = 1, max = 30, message="API_DTO - Invalid firstName")
	private String firstName;
	@NotNull(message="API_DTO - lastName can't be null")
	@Size(min = 1, max = 30, message="API_DTO - Invalid lastName")
	private String lastName;
	@NotNull(message="API_DTO - email can't be null")
	@Email(message="API_DTO - Invalid email")
	private String email;
	@Size(max = 14, message="API_DTO - Phone number too large")
	private String optionalPhone;
	@NotNull(message="API_DTO - Birthday can't be null")
	private Date birthday;
	public AccountCreationDTO() {
		
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
	public String getOptionalPhone() {
		return optionalPhone;
	}
	public void setOptionalPhone(String optionalPhone) {
		this.optionalPhone = optionalPhone;
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
