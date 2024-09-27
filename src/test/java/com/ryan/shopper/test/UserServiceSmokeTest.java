package com.ryan.shopper.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ryan.shopper.shopperserv.dto.UserInfoDTO;
import com.ryan.shopper.shopperserv.entity.UserEntity;
import com.ryan.shopper.shopperserv.repository.UserInfoRepository;
import com.ryan.shopper.shopperserv.repository.UserRepository;
import com.ryan.shopper.shopperserv.service.UserServiceImpl;

import java.time.LocalDate;
import java.util.Optional;
import static org.mockito.Mockito.*;
import java.sql.Date;;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceSmokeTest {
	@Mock
	private UserRepository userRepo;
	
	@Mock
	private UserInfoRepository userInfoRepo;
	
	@InjectMocks
	private UserServiceImpl userService; 
	
	@Test
	public void testAuthenticateUserSuccessful() {
		String testUsername = "testUser";
		String testPassword = "testpw";
		Integer testUserID = 1; 
		String testUserFirstName = "Test";
		String testUserLastName = "User";
		String testUserEmail = "test@test.com";
		String testUserPhone = "4015555555";
		LocalDate testUserBday = LocalDate.of(1992, 4, 7);
		
		when(userRepo.findByUserNameAndPassword(testUsername, testPassword)).
		thenReturn(Optional.of(new UserEntity(testUserID, testUsername, testPassword)));
		
		
		
		
		//new UserInfoDTO(testUserID, testUserFirstName, testUserLastName, testUserEmail, testUserPhone, testUserBday)
	}
}
