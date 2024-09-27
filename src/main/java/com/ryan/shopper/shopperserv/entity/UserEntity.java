package com.ryan.shopper.shopperserv.entity;

import com.ryan.shopper.shopperserv.dto.UserDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "userId")
	UserInfoEntity userInfo; 
	
	public UserEntity() {
		
	}
	public UserEntity(Integer id, String username, String password) {
		this.id = id;
		this.userName = username;
		this.password = password;
	}
	public Integer getId() {return this.id;}
	public String getUserName() {return this.userName;}
	public String getPassword() {return this.password;}
	
	public void setId(Integer newId) { this.id = newId;}
	public void setUserName(String uname) { this.userName = uname;}
	public void setPassword(String password) { this.password = password;}
	public UserInfoEntity getUserInfoEntity() { return this.userInfo;} 
	
	public UserDTO toDTO() {
		return new UserDTO(this.getId(),
						   this.getUserName(),
						   this.getPassword());
	}
	
	
	
	
}
