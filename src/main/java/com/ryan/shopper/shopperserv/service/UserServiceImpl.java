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


	
}
