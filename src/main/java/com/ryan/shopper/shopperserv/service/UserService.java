package com.ryan.shopper.shopperserv.service;

import com.ryan.shopper.shopperserv.dto.AccountCreationDTO;
import com.ryan.shopper.shopperserv.dto.UserInfoDTO;
import com.ryan.shopper.shopperserv.exception.UserAlreadyExistsException;
import com.ryan.shopper.shopperserv.exception.UserInfoNotFoundException;
import com.ryan.shopper.shopperserv.exception.UserInfoValidationException;
import com.ryan.shopper.shopperserv.exception.UserNotFoundException;

public interface UserService {
	public UserInfoDTO authenticateUser(String username, String password) throws UserNotFoundException, UserInfoNotFoundException;
	public void createNewUser(AccountCreationDTO userInfo) throws UserAlreadyExistsException, UserInfoValidationException;
}
