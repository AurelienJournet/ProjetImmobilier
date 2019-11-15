package com.fr.adaming.service.impl;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Rule;
=======
>>>>>>> 8f95c0007689c393fc0ff572d1940cd03500b10f
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.entity.Agent;
import com.fr.adaming.entity.Client;
import com.fr.adaming.enumeration.TypeClient;
import com.fr.adaming.service.IAgentService;

@SpringBootTest
@RunWith(SpringRunner.class)

public class AgentServiceImplTest {

	@Autowired
	private IAgentService service;

	@Test
	@Sql(statements = "Truncate Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createValidAgent_shouldReturnAgentWithIdNotNull() {

		Agent agent = new Agent("agent@agent.fr","pwd","NomAgent",LocalDate.of(2019, 10, 15));
		agent = service.saveAgent(agent);
		assertTrue(agent.getId() != null);
		assertEquals(agent.getEmail(), "agent@agent.fr");
		assertEquals(agent.getFullName(), "NomAgent");
		assertEquals(agent.getPwd(),"pwd");
		assertEquals(agent.getDateRecrutement(),LocalDate.of(2019, 10, 15));
	}

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	@Sql(statements = "Truncate Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createNotValidAgent_shouldReturnException() {

		exceptionRule.expect(DataIntegrityViolationException.class);
		Agent agent = new Agent();
		agent.setEmail(null);
		service.saveAgent(agent);
	}

	@Test
	@Sql(statements = { "Truncate Agent",
			"Insert into Agent (id,email,pwd,full_name,telephone,date_recrutement) values (1,'agent@agent.fr','pwd','nomAgent',0101010101,'2019-10-14')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createAgentWithAlreadyExistingEmail_shouldReturnException() {
		exceptionRule.expect(DataIntegrityViolationException.class);
		Agent agent = new Agent("agent@agent.fr","pwd", "NomClient", LocalDate.of(2019, 10, 15));
		service.saveAgent(agent);
	}

	@Test
	@Sql(statements = {"Truncate Agent","insert into Agent (id,email,full_name,telephone,type) values (404,'client@client.fr','nomClient',0101010101,'ACHETEUR')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidClient_shouldReturnTrue() {
		Client client=service.findClientById(404L);
		client.setType(TypeClient.VENDEUR);
		assertTrue(service.updateClient(client)); 
		assertEquals(service.findClientById(404L).getType(),TypeClient.VENDEUR);
	}
//
//	@Test
//	@Sql(statements = "Truncate Client", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	public void updateUnknowClient_shouldReturnFalse() {
//		Client client = new Client(1L, "client@client.fr", "NomClient", TypeClient.ACHETEUR);
//		assertFalse(service.updateClient(client));
//	}
//
//	@Test
//	@Sql(statements = { "Truncate Client",
//			"Insert into Client (id,email,full_name,telephone,type) values (1,'client@client.fr','nomClient',0101010101,'ACHETEUR')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	public void deleteValidClient_shouldReturnTrue() {
//
//		assertTrue(service.deleteClient(service.findClientById(1L)));
//	}
//
//	@Test
//	@Sql(statements = { "Truncate Client",
//			"Insert into Client (id,email,full_name,telephone,type) values (1,'client@client.fr','nomClient',0101010101,'ACHETEUR')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	public void deleteUnknowClient_shouldReturnFalse() {
//		Client client = new Client("client2@client.fr", "NomClient2", TypeClient.ACHETEUR);
//		assertFalse(service.deleteClient(client));
//	}
//
//	@Test
//	@Sql(statements = { "Truncate Client",
//			"Insert into Client (id,email,full_name,telephone,type) values (1,'client@client.fr','nomClient',0101010101,'ACHETEUR')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	public void getValidClientById_shouldReturnThisClient() {
//		Client client = service.findClientById(1L);
//		assertEquals(client.getEmail(), "client@client.fr");
//		assertEquals(client.getFullName(), "nomClient");
//	}
//
//	@Test
//	@Sql(statements = "Truncate Client", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	public void getUnknowClientById_shouldReturnNull() {
//		assertNull(service.findClientById(1L));
//	}

}
