package com.ryan.shopper.shopperserv.service;

import com.ryan.shopper.shopperserv.dto.UserInfoDTO;
import com.ryan.shopper.shopperserv.exception.UserInfoNotFoundException;
import com.ryan.shopper.shopperserv.exception.UserNotFoundException;

public interface UserService {
	public UserInfoDTO authenticateUser(String username, String password) throws UserNotFoundException, UserInfoNotFoundException;
}
