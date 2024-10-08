package com.ryan.shopper.shopperserv.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.shopper.shopperserv.dto.AccountCreationDTO;
import com.ryan.shopper.shopperserv.dto.UserDTO;
import com.ryan.shopper.shopperserv.dto.UserInfoDTO;
import com.ryan.shopper.shopperserv.exception.UserAlreadyExistsException;
import com.ryan.shopper.shopperserv.exception.UserInfoNotFoundException;
import com.ryan.shopper.shopperserv.exception.UserInfoValidationException;
import com.ryan.shopper.shopperserv.exception.UserNotFoundException;
import com.ryan.shopper.shopperserv.service.UserServiceImpl;

import jakarta.validation.Valid;


@RestController("UserAPI")
@RequestMapping("users/api")
@CrossOrigin(origins = "*")
public class UserAPI {
	
	@Autowired
	UserServiceImpl userService;

	

	@PostMapping("/login")
	UserInfoDTO userLogin(@Valid @RequestBody UserDTO user) throws UserNotFoundException, UserInfoNotFoundException, UserInfoValidationException{
		UserInfoDTO potentialUser = userService.authenticateUser(user.getUserName(), user.getPassword()); 
		return potentialUser;
	}
	@PostMapping("/create-account")
	boolean accountCreation(@Valid @RequestBody AccountCreationDTO userInfo) throws UserAlreadyExistsException, UserInfoValidationException {
		userService.createNewUser(userInfo); 
		return true;
	}
	@PostMapping("/check-username")
	@CrossOrigin(origins = "http://localhost:5500/")
	boolean validateUsernameUnique(@Valid @RequestBody UserDTO username) throws UserAlreadyExistsException{
		return userService.checkIfUserExists(username);
	}
}
