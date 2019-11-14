package com.fr.adaming.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.service.IUserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@Autowired
	private IUserService service;
	
	
	@Test
	public void exempleDeTest() {
		boolean x = true;
		
		assertTrue(x);
	}
}
