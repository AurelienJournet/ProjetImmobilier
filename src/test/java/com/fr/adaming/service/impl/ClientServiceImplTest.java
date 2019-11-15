package com.fr.adaming.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.entity.Client;
import com.fr.adaming.enumeration.TypeClient;
import com.fr.adaming.service.IClientService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientServiceImplTest {

		@Autowired
		private IClientService service;
		
		@Test
		@Sql(statements = "Truncate Client",executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
		public void createValidClient_shouldReturnClientrWithIdNotNull() {
			
			Client client=new Client("client@client.fr","NomClient",TypeClient.ACHETEUR);	
			
			assertTrue(service.addClient(client).getId()!=null);	
		}
		
		@Test
		public void createNotValidClient_shouldReturnException(){
			//exceptionRule.expect(NumberFormatException.class);
			Client client=new Client();
			client.setEmail(null);
			service.addClient(client);
			
		}
		
		@Test
		public void updateValidBien_shouldReturnBienUpdated() {
			
		}
		
		@Test
		public void updateUnknowBien_shouldReturnException() {
			
		}
		
		@Test
		public void deleteValidBien_shouldReturnTrue() {
			
		}
		
		@Test
		public void deleteUnknowBien_shouldReturnFalse() {
			
		}

		@Test
		public void getValidBienById_shouldReturnThisBien() {
			
		}
		
		@Test
		public void getUnknowBienById_shouldReturnException() {
			
		}
		
		
	
}
