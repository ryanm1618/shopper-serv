package com.ryan.shopper.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.ryan.shopper.shopperserv.dto.UserDTO;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
class UserAPISmokeTest {

	@Test
	void contextLoads() {
	}
	@Autowired
	MockMvc mockedAPI; 
	
	/**
	 * PAUSING WORK ON THIS FOR NOW TO FOCUS ON THE SERVICE LAYER - 9/22/24
	 * @throws Exception
	 */
	@Test
	public void testLoginSuccessful() throws Exception { 
		UserDTO testUser = new UserDTO(0, "test", "testpw");
		
		ResultActions results = mockedAPI.perform(post("/users/api/login", testUser));
		
		results.andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}

}
