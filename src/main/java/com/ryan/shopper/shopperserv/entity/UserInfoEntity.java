package com.ryan.shopper.shopperserv.entity;

import java.sql.Timestamp;

import com.ryan.shopper.shopperserv.dto.UserInfoDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_info")
public class UserInfoEntity {
	@Column(name = "first_name")
	String firstName;
	@Column(name = "last_name")
	String lastName;
	@Column(name = "email")
	String email;
	@Column(name = "optional_phone")
	String phone;
	@Column(name = "last_login_date")
	Timestamp lastLogin;
	@Column(name = "creation_date")
	Timestamp creationDate;
	@Id
	@Column(name = "user_id")
	Integer userId;
	
	@OneToOne(mappedBy = "userInfo")
	private UserEntity userLogin; 
	
	public UserInfoDTO toDTO() {
		return new UserInfoDTO(this.userId, this.firstName, this.lastName, this.email, this.phone, this.lastLogin, this.creationDate);
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
