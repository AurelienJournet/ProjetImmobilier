package com.fr.adaming.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.service.IAgentService;

@SpringBootTest
@RunWith(SpringRunner.class)

public class AgentServiceImplTest {

	@Autowired
	private IAgentService service;
	
	
	@Test
	public void exempleDeTest() {
		boolean x = true;
		
		assertTrue(x);
	}
	
	@Test
	public void getAllAgentWithAtLeastOne_shouldReturnListAgents() {
		
	}
	
	@Test
	public void getAllAgentWithNone_shouldReturnEmptyList() {
		
	}
	
	@Test
	public void createValidAgent_shouldReturnAgentWithIdNotNull() {
		
	}
	
	@Test
	public void createNotValidAgent_shouldReturnException(){
		//Mauvaix id ou email déjà utilisé ...
	}
	
	@Test
	public void updateValidAgent_shouldReturnAgentUpdated() {
		
	}
	
	@Test
	public void updateUnknowAgent_shouldReturnException() {
		
	}
	
	@Test
	public void deleteValidAgent_shouldReturnTrue() {
		
	}
	
	@Test
	public void deleteUnknowAgent_shouldReturnFalse() {
		
	}

	@Test
	public void getValidAgentById_shouldReturnThisAgent() {
		
	}
	
	@Test
	public void getUnknowAgentById_shouldReturnException() {
		
	}
}
