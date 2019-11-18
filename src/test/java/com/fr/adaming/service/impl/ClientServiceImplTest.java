package com.fr.adaming.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.entity.Client;
import com.fr.adaming.enumeration.TypeClient;
import com.fr.adaming.service.IClientService;
/**
 * @author Aurélien
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientServiceImplTest {

		@Autowired
		private IClientService service;
		
		@Test
		@Sql(statements = "Delete From Client",executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
		public void createValidClient_shouldReturnClientrWithIdNotNull() {
			
			Client client=new Client("client@client.fr","NomClient",TypeClient.ACHETEUR);	
			client=service.addClient(client);
			assertTrue(client.getId()!=null);
			assertEquals(client.getEmail(),"client@client.fr");
			assertEquals(client.getFullName(),"NomClient");
			assertEquals(client.getType(),TypeClient.ACHETEUR);
		}
		
		@Test
		@Sql(statements = {"Delete From Client","Insert into Client (id,email,full_name,telephone,type) values (1,'client@client.fr','nomClient',0101010101,'ACHETEUR')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
		public void createAlreadyExistingClient_shouldReturnNull() {
		
			assertNull(service.addClient(service.findClientById(1L)));		
		}
		
		@Rule
		public ExpectedException exceptionRule = ExpectedException.none();
		
		@Test
		@Sql(statements = "Delete From Client",executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
		public void createNotValidClient_shouldReturnException(){
			
			exceptionRule.expect(DataIntegrityViolationException.class);
			Client client=new Client();
			client.setEmail(null);
			service.addClient(client);	
		}
		
		@Test
		@Sql(statements = {"Delete From Client","Insert into Client (id,email,full_name,telephone,type) values (1,'client@client.fr','nomClient',0101010101,'ACHETEUR')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
		public void createClientWithAlreadyExistingEmail_shouldReturnException() {
			exceptionRule.expect(DataIntegrityViolationException.class);
			Client client=new Client("client@client.fr","NomClient",TypeClient.ACHETEUR);	
			service.addClient(client);	
		}
		
		@Test
		@Sql(statements = {"Delete From Client","insert into Client (id,email,full_name,telephone,type) values (404,'client@client.fr','nomClient',0101010101,'ACHETEUR')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
		public void updateValidClient_shouldReturnTrue() {
			Client client=service.findClientById(404L);
			client.setType(TypeClient.VENDEUR);
			assertTrue(service.updateClient(client)); 
			assertEquals(service.findClientById(404L).getType(),TypeClient.VENDEUR);
		}
		
		@Test
		@Sql(statements = "Delete From Client",executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
		public void updateUnknowClient_shouldReturnFalse() {
			Client client=new Client(1L,"client@client.fr","NomClient",TypeClient.ACHETEUR);
			assertFalse(service.updateClient(client));		
		}
		
		@Test
		@Sql(statements = {"Delete From Client","Insert into Client (id,email,full_name,telephone,type) values (1,'client@client.fr','nomClient',0101010101,'ACHETEUR')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
		public void deleteValidClient_shouldReturnTrue() {

			assertTrue(service.deleteClient(service.findClientById(1L)));
		}
		
		@Test
		@Sql(statements = {"Delete From Client","Insert into Client (id,email,full_name,telephone,type) values (1,'client@client.fr','nomClient',0101010101,'ACHETEUR')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
		public void deleteUnknowClient_shouldReturnFalse() {
			Client client=new Client("client2@client.fr","NomClient2",TypeClient.ACHETEUR);
			assertFalse(service.deleteClient(client));
		}

		@Test
		@Sql(statements = {"Delete From Client","Insert into Client (id,email,full_name,telephone,type) values (1,'client@client.fr','nomClient',0101010101,'ACHETEUR')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
		public void getValidClientById_shouldReturnThisClient() {
			Client client=service.findClientById(1L);
			assertEquals(client.getEmail(),"client@client.fr");
			assertEquals(client.getFullName(),"nomClient");	
		}
		
		@Test
		@Sql(statements = "Delete From Client",executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
		public void getUnknowClientById_shouldReturnNull() {
			assertNull(service.findClientById(1L));
		}
}
