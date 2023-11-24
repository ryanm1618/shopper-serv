package com.ryan.shopper.shopperserv.entity;

import com.ryan.shopper.shopperserv.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	Integer id;
	@Column(name="username")
	String userName;
	@Column(name="password")
	String password;
	
	Integer getId() {return this.id;}
	String getUserName() {return this.userName;}
	String getPassword() {return this.password;}
	
	void setId(Integer newId) { this.id = newId;}
	void setUserName(String uname) { this.userName = uname;}
	void setPassword(String password) { this.password = password;}
	
	public UserDTO toDTO() {
		return new UserDTO(this.getId(),
						   this.getUserName(),
						   this.getPassword());
	}
	
	
	
	
}
