package com.fr.adaming.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.junit.Rule;
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
import com.fr.adaming.service.IAgentService;

/**
 * @author VITTOZ Guillaume & JOURNET Aurelien
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AgentServiceImplTest {

	@Autowired
	private IAgentService service;
	
	private static final Logger logger = Logger.getLogger("com.fr.adaming.service.impl.AgentServiceTestImpl");

	@Test
	@Sql(statements = "Delete From Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createValidAgent_shouldReturnAgentWithIdNotNull() {


		
		Agent agent = new Agent(1L,"agent@agent.fr","pwd","NomAgent",LocalDate.of(2019, 10, 15));

		agent = service.saveAgent(agent);
		assertTrue(agent.getId() != null);
		assertEquals(agent.getEmail(), "agent@agent.fr");
		assertEquals(agent.getFullName(), "NomAgent");
		assertEquals(agent.getPwd(), "pwd");
		assertEquals(agent.getDateRecrutement(), LocalDate.of(2019, 10, 15));
		
		
		logger.debug("TEST CREATE VALID AGENT (DEBUG)");
	}

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	@Sql(statements = "Delete From Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createNotValidAgent_shouldThrowException() {
		exceptionRule.expect(DataIntegrityViolationException.class);
		
		Agent agent = new Agent();
		agent.setEmail(null);
		agent.setId(1L);
		service.saveAgent(agent);
		
		logger.debug("TEST CREATE NOT VALID AGENT (DEBUG)");
	}

	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone,date_recrutement) values (1,'agent@agent.fr','pwd','nomAgent',0101010101,'2019-10-14')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createExistingAgent_shouldReturnNull() {
		Agent agent = service.getAgentById(1L);
		assertNull(service.saveAgent(agent));
		
		logger.debug("TEST CREATE EXISTING AGENT (DEBUG)");
	}

	@Test
	@Sql(statements = { "Delete From Agent",
			"Insert into Agent (id,email,pwd,full_name,telephone,date_recrutement) values (1,'agent@agent.fr','pwd','nomAgent',0101010101,'2019-10-14')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createAgentWithAlreadyExistingEmail_shouldReturnNull() {
		exceptionRule.expect(DataIntegrityViolationException.class);
		Agent agent = new Agent(5L,"agent@agent.fr","pwd", "NomClient", LocalDate.of(2019, 10, 15));
		assertNull(service.saveAgent(agent));
		logger.debug("TEST CREATE AGENT EXISTING EMAIL (DEBUG)");
	}

	@Test
	@Sql(statements = { "Delete From Agent",
	"Insert into Agent (id,email,pwd,full_name,telephone,date_recrutement) values (404,'agent@agent.fr','pwd','nomAgent',0101010101,'2019-10-14')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidAgent_shouldReturnTrue() {
		Agent agent=service.getAgentById(404L);
		agent.setDateRecrutement(LocalDate.of(2018, 9, 13));
		assertEquals(service.updateAgent(agent).getDateRecrutement(),LocalDate.of(2018, 9, 13));
		logger.debug("TEST UPDATE VALID AGENT(DEBUG)");
	}

	@Test
	@Sql(statements = "Delete From Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateUnknowAgent_shouldReturnFalse() {
		Agent agent =new Agent(1L,"agent@agent.fr","pwd","NomAgent",LocalDate.of(2019, 10, 15));
		assertNull(service.updateAgent(agent));
		logger.debug("TEST UPDATE UNKNOWN AGENT(DEBUG)");
	}

	@Test
	@Sql(statements = { "Delete From Agent",
			"Insert into Agent (id,email,full_name,telephone,pwd,date_Recrutement) values (1,'agent@agent.fr','nomAgent',0101010101,'pwd', '5-12-25')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void deleteValidAgent_shouldReturnTrue() {
		assertTrue(service.deleteAgent(1L));
		logger.debug("TEST DELETE VALID AGENT(DEBUG)");
	}

	@Test
	@Sql(statements = { "Delete From Agent",
			"Insert into Agent (id,email,full_name,telephone,pwd,date_Recrutement) values (1,'agent@agent.fr','nomAgent',0101010101,'pwd', '5-12-25')" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void deleteUnknowAgent_shouldReturnFalse() {
		assertFalse(service.deleteAgent(404L));
		logger.debug("TEST DELETE UNKNOWN AGENT(DEBUG)");
	}

	@Test

	@Sql(statements = { "Delete From Agent",
			"Insert into Agent (id,email,full_name,telephone,pwd,date_Recrutement) values (1,'agent@agent.fr','nomAgent',0101010101,'pwd', '201-12-25')"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void getValidAgentById_shouldReturnThisAgent() {
		Agent agent = service.getAgentById(1L);
		assertEquals(agent.getEmail(), "agent@agent.fr");
		assertEquals(agent.getFullName(), "nomAgent");
		logger.debug("TEST GET VALID AGENT BY ID (DEBUG)");
	}

	@Test
	@Sql(statements = "Delete From Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void getUnknowAgentById_shouldReturnNull() {
		assertNull(service.getAgentById(1L));
		logger.debug("TEST GET UNKNWON AGENT BY ID (DEBUG)");
	}
}
