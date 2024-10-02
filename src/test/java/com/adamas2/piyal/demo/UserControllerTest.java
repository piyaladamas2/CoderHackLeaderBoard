package com.adamas2.piyal.demo;


import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.adamas2.piyal.demo.controller.UserController;
import com.adamas2.piyal.demo.service.UserService;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

	

	@MockBean
	private UserService userService;

	@InjectMocks
  	private UserController userController;
	
	//private ObjectMapper objectMapper;

	@BeforeEach
  	public void setup() {
	//	objectMapper = new ObjectMapper();

    

  //  mvc = MockMvcBuilders.standaloneSetup(userController).build();
  }


	
	


}
