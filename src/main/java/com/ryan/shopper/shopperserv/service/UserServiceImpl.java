package com.ryan.shopper.shopperserv.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.shopper.shopperserv.dto.UserDTO;
import com.ryan.shopper.shopperserv.dto.UserInfoDTO;
import com.ryan.shopper.shopperserv.entity.UserEntity;
import com.ryan.shopper.shopperserv.entity.UserInfoEntity;
import com.ryan.shopper.shopperserv.exception.UserInfoNotFoundException;
import com.ryan.shopper.shopperserv.exception.UserNotFoundException;
import com.ryan.shopper.shopperserv.repository.UserInfoRepository;
import com.ryan.shopper.shopperserv.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository repo; 
	
	@Autowired
	private UserInfoRepository infoRepo;
	
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
}
