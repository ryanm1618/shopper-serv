package com.ryan.shopper.shopperserv.service;


import java.util.Optional;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.shopper.shopperserv.dto.AccountCreationDTO;
import com.ryan.shopper.shopperserv.dto.UserDTO;
import com.ryan.shopper.shopperserv.dto.UserInfoDTO;
import com.ryan.shopper.shopperserv.entity.UserEntity;
import com.ryan.shopper.shopperserv.entity.UserInfoEntity;
import com.ryan.shopper.shopperserv.exception.UserAlreadyExistsException;
import com.ryan.shopper.shopperserv.exception.UserInfoNotFoundException;
import com.ryan.shopper.shopperserv.exception.UserInfoValidationException;
import com.ryan.shopper.shopperserv.exception.UserNotFoundException;
import com.ryan.shopper.shopperserv.repository.UserInfoRepository;
import com.ryan.shopper.shopperserv.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository repo; 
	
	@Autowired
	private UserInfoRepository infoRepo;
	
	Properties authProps = new Properties();
	
	public UserServiceImpl() {
		//authProps.load(new FileInputStream("./auth.properties"));
	}
	
	public UserInfoDTO authenticateUser(String username, String password) throws UserNotFoundException, UserInfoNotFoundException{
		UserEntity fromDBEntity;
		Optional<UserEntity> fromDBOptional  = this.repo.findByUserNameAndPassword(username, password);
		if(fromDBOptional.isEmpty()) { 
			throw new UserNotFoundException("Unable to login using username: " + username + " and password: " + password);
		}
		fromDBEntity = fromDBOptional.get();
		UserInfoDTO userInfo; 	
		userInfo = this.getAccountDetails(fromDBEntity.toDTO());
		return userInfo;
		
	}
	private UserInfoDTO getAccountDetails(UserDTO user) throws UserInfoNotFoundException{
		UserInfoEntity fromDBEntity; 
		Optional<UserInfoEntity> fromDBOptional = this.infoRepo.findByUserId(user.getUserId());
		if(fromDBOptional.isEmpty()) {
			throw new UserInfoNotFoundException("Unable to retrieve user info. Please try again later."); 
		}
		fromDBEntity = fromDBOptional.get();
		return fromDBEntity.toDTO();
		
	}
	public boolean checkIfUserExists(UserDTO user) throws UserAlreadyExistsException {
		Optional<UserEntity> fromDBOptional = this.repo.findByUserName(user.getUserName()); 
		System.out.println("USERNAME BEING VALIDATED:"+user.getUserName()+"</END>");
		if(fromDBOptional.isEmpty()) {
			return false;
		}
		throw new UserAlreadyExistsException("The username is already taken.");
	}
	public void createNewUser(AccountCreationDTO userInfo) throws UserAlreadyExistsException, UserInfoValidationException{
		Optional<UserEntity> fromDBOptional = this.repo.findByUserName(userInfo.getUserName()); 
		if(fromDBOptional.isEmpty()) {
			UserDTO newUser = userInfo.toUserDTO();
			UserInfoDTO newUserInfo = userInfo.toUserInfoDTO();
			
			UserEntity newUserEntity = newUser.toEntity();
			UserInfoEntity newUserInfoEntity = newUserInfo.toEntity();
			
			UserEntity updatedUserEntity = this.repo.save(newUserEntity);
			newUserInfoEntity.setUserId(updatedUserEntity.getId());
			this.infoRepo.save(newUserInfoEntity);
		}else {
			throw new UserAlreadyExistsException("That username is already taken. Please choose another.");
		}
	}
	/**
	 * Validation Rules - 
	 * ->username and password must be at least 8 characters long, but less than 30
	 * ->First name should be greater than or equal to 1 character
	 * ->Last name should be greater than or equal to 1 character
	 * ->Email validation should use the following regex: 
	 * 		/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/
	 * ->optionalPhone should not be greater than 14 characters (only numbers) 
	 * ->birthday will be validated using the following regex for MM/DD/YYYY format: 
	 * 		/^(0[1-9]|1[0-2])\/(0[1-9]|1\d|2\d|3[01])\/(19|20)\d{2}$/
	 */
	public void validateAccountCreationDTO(AccountCreationDTO userInfo) throws UserInfoValidationException {

		//Username
		if(userInfo.getUserName().length() < 8 || userInfo.getUserName().length() > 30) {
			throw new UserInfoValidationException("Username must be between 8 and 30 characters.");
		}
		//Password
		if(userInfo.getPassword().length() < 8 || userInfo.getPassword().length() > 30) {
			throw new UserInfoValidationException("Password must be between 8 and 30 characters.");
		}
		//Firstname
		if(userInfo.getFirstName().length() < 1 || userInfo.getFirstName().length() > 30) {
			throw new UserInfoValidationException("First name should be between 1 and 30 characters long.");
		}
		//Lastname
		if(userInfo.getLastName().length() < 1 || userInfo.getLastName().length() > 30) {
			throw new UserInfoValidationException("Last name should be between 1 and 30 characters long.");
		}
		//Email
		if(userInfo.getEmail().length() > 5 && userInfo.getEmail().length() < 100) {
			Pattern emailPattern = Pattern.compile("/^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$/");
			Matcher patternMatcher = emailPattern.matcher(userInfo.getEmail());
			
			if(!patternMatcher.find()) {
				throw new UserInfoValidationException("Invalid email entered.");
			}
			
		}else {
			throw new UserInfoValidationException("Email should be less than 100 characters.");
		}
		//Optional Phone Number
		if(userInfo.getOptionalPhone().length() > 14) {
			throw new UserInfoValidationException("Phone number should be 14 characters or less");
		}
		//Birthday
		if(userInfo.getBirthday().length() != 10) {
			throw new UserInfoValidationException("Invalid date. Must be in MM/DD/YYYY format.");
		}else {
			Pattern birthdayPattern = Pattern.compile("/^(0[1-9]|1[0-2])\\/(0[1-9]|1\\d|2\\d|3[01])\\/(19|20)\\d{2}$/");
			Matcher patternMatcher = birthdayPattern.matcher(userInfo.getBirthday());
			
			if(!patternMatcher.find()) {
				throw new UserInfoValidationException("Invalid birthday.");
			}
		}
		
		
	}
}
