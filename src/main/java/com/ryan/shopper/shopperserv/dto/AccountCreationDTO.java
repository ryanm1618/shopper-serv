package com.ryan.shopper.shopperserv.dto;

import java.sql.Timestamp;

public class AccountCreationDTO {
	private String userName; 
	private String password; 
	private String firstName;
	private String lastName;
	private String email;
	private String optionalPhone;
	private String birthday;
	public AccountCreationDTO(String userName, String password, String firstName, String lastName, String email,
			String optionalPhone, String birthday) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.optionalPhone = optionalPhone;
		this.birthday = birthday;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public UserInfoDTO createUserInfoDTO() {
		return new UserInfoDTO(null, birthday, birthday, birthday, birthday, null, null);
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
		returnDTO.setLastLogin(null);
		returnDTO.setCreationDate(new Timestamp(System.currentTimeMillis()));
		
		return returnDTO;
	}
	
}
