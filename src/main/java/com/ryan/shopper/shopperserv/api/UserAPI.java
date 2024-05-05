package com.ryan.shopper.shopperserv.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.shopper.shopperserv.dto.UserDTO;
import com.ryan.shopper.shopperserv.dto.UserInfoDTO;
import com.ryan.shopper.shopperserv.exception.UserInfoNotFoundException;
import com.ryan.shopper.shopperserv.exception.UserNotFoundException;
import com.ryan.shopper.shopperserv.service.UserServiceImpl;

@RestController("UserAPI")
@RequestMapping("users/api")
public class UserAPI {
	
	@Autowired
	UserServiceImpl userService;

	
	@PostMapping("/login")
	UserInfoDTO userLogin(String username,  String password) throws UserNotFoundException, UserInfoNotFoundException{
		UserInfoDTO potentialUser = userService.authenticateUser(username, password); 
		return potentialUser;
	}
}
