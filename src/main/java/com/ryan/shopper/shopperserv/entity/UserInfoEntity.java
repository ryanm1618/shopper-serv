package com.ryan.shopper.shopperserv.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
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
	@Column(name = "sec_ques_one")
	String securityQuestionOne;
	@Column(name = "sec_answ_one")
	String securityAnswerOne;
	@Column(name = "sec_ques_two")
	String securityQuestionTwo;
	@Column(name = "sec_answ_two")
	String securityAnswerTwo;
	@Column(name = "creation_date")
	LocalDateTime creationDate;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	Integer userId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName  = "id")
	UserEntity userLogin; 
}
