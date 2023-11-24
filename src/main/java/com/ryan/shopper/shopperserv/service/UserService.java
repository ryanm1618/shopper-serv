package com.ryan.shopper.shopperserv.service;

import com.ryan.shopper.shopperserv.dto.UserDTO;
import com.ryan.shopper.shopperserv.dto.UserInfoDTO;
import com.ryan.shopper.shopperserv.exception.UserNotFoundException;

public interface UserService {
	public UserDTO authenticateUser(String username, String password) throws UserNotFoundException;
	public UserInfoDTO getAccountDetails(UserDTO user);
}
