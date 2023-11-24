package com.ryan.shopper.shopperserv.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.shopper.shopperserv.dto.UserDTO;
import com.ryan.shopper.shopperserv.dto.UserInfoDTO;
import com.ryan.shopper.shopperserv.entity.UserEntity;
import com.ryan.shopper.shopperserv.exception.UserNotFoundException;
import com.ryan.shopper.shopperserv.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository repo; 
	
	public UserDTO authenticateUser(String username, String password) throws UserNotFoundException {
		UserEntity fromDBEntity;
		Optional<UserEntity> fromDBOptional  = this.repo.findByUserNameAndPassword(username, password);
		if(fromDBOptional.isEmpty()) { //If user isn't found in db or some error occurred
			throw new UserNotFoundException("Bad login info. Try again!");
		}
		fromDBEntity = fromDBOptional.get();
		return fromDBEntity.toDTO();
	}
	public UserInfoDTO getAccountDetails(UserDTO user) {
		return new UserInfoDTO();
	}
}
