package com.fr.adaming.web.controller.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.util.NestedServletException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fr.adaming.ProjetImmobilierApplicationTests;
import com.fr.adaming.web.dto.AgentDto;
import com.fr.adaming.web.dto.ClientDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgentControllerImplTest extends ProjetImmobilierApplicationTests {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	@Sql(statements = "Delete From Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void addValidAgent_shouldReturnSUCCESSFULL() throws Exception {

		AgentDto agent = new AgentDto("agent@agent.fr", "NomAgent", "0632100132","pwdEntre8et16",
				null);

		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.post("/api/agent/save").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(agent))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		AgentDto response = mapper.readValue(bodyAsJson, AgentDto.class);
		
		assertNotNull(response);
		assertEquals("agent@agent.fr", response.getEmail());
		assertEquals("NomAgent", response.getFullName());
		assertEquals("0632100132", response.getTelephone());
		assertEquals("pwdEntre8et16", response.getPwd());
		assertEquals(null, response.getDateRecrutement());
	}
	
	@Test
	@Sql(statements = "Delete From Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void addAgentWithUnvalidEmail_shouldReturnStatus400() throws Exception {
		
		AgentDto agent=new AgentDto("agentsansarobasagent.fr", "NomAgent", "0632100132","pwdEntre8et16",
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/client/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = "Delete From Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void addAgentWithUnvalidPhone_shouldReturnStatus400() throws Exception {
		
		AgentDto agent=new AgentDto("agent@agent.fr", "NomAgent", "063210013A","pwdEntre8et16",
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/client/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andExpect(status().is(400));
	}
	
	@Test
	@Sql(statements = "Delete From Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void addAgentWithBlankName_shouldReturnStatus400() throws Exception {
		
		AgentDto agent=new AgentDto("agent@agent.fr","   ","0632100132","pwdEntre8et16",
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/client/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andExpect(status().is(400));
	}
	
	@Test
	@Sql(statements = "Delete From Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void addAgentWithUnvalidShortPwd_shouldReturnStatus400() throws Exception {
		exceptionRule.expect(NestedServletException.class);
		
		AgentDto agent=new AgentDto("agent@agent.fr","NomAgent","0632100132","court",
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/client/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andExpect(status().is(400));
	}
	
	@Test
	@Sql(statements = "Delete From Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void addAgentWithUnvalidLongPwd_shouldReturnStatus400() throws Exception {
		exceptionRule.expect(NestedServletException.class);
		
		AgentDto agent=new AgentDto("agent@agent.fr","NomAgent","0632100132","beaucoupTropLongOuPresque",
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/client/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andExpect(status().is(400));
	}
	
	@Test
	@Sql(statements = "Delete From Agent", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void getAllAgents_shouldReturnEmptyListOfAgents() throws UnsupportedEncodingException, Exception {
		String result = mvc.perform(get("/api/agent/getAll").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		System.out.println("DEBUG DE LA METHODE GETALL : " + result);
	}
	

	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (185,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void getValidAgentById_shouldReturnStatus200() throws Exception {		
		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.get("/api/agent/185/getById").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(200)).andReturn().getResponse().getContentAsString();
	
		AgentDto response = mapper.readValue(bodyAsJson, AgentDto.class);
		
		assertNotNull(response);
		assertEquals(185L, response.getId());
		assertEquals("agent@agent.fr", response.getEmail());
		assertEquals("nomAgent", response.getFullName());
		assertEquals("0632100132", response.getTelephone());
		assertEquals("pwdTailleOk", response.getPwd());

	}
	
	@Test
	public void foundById_AgentNotFound_ShouldReturnNull() throws Exception {
		exceptionRule.expect(NestedServletException.class);
		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.get("/api/agent/201/getById").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
		System.out.println("DEBUG response : "+ bodyAsJson);
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (185,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132'),(186,'agent2@agent2.fr','pwdTailleOk2','nomAgent2','0632100131')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void getAllAgents_shouldReturnStatus200() throws UnsupportedEncodingException, Exception {
		
		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.get("/api/agent/getAll").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(200)).andReturn().getResponse().getContentAsString();
			
		List<AgentDto> response = mapper.readValue(bodyAsJson, new TypeReference<List<AgentDto>>() {});
	
		assertEquals(response.size(),2);
        assertTrue(response.get(0).getEmail().equals("agent@agent.fr"));
        assertTrue(response.get(1).getEmail().equals("agent2@agent2.fr"));
	}

	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void deleteValidAgent_ShouldReturnFalse() throws Exception {
		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.get("/api/agent/5/delete")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse().getContentAsString();
		
		assertEquals("true", bodyAsJson);
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void deleteUnknownAgent_ShouldReturnFalse() throws Exception {
		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.get("/api/agent/2/delete")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn().getResponse().getContentAsString();
		
		assertEquals("false", bodyAsJson);
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidAgent_ShouldReturnAgentUpdated() throws Exception {
		AgentDto agent=new AgentDto(1L, "agentMODIF@agent.fr", "NomAgentMODIF", "0632100132","pwdEntre8et16",
				null);
		
		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.put("/api/agent/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
	
		AgentDto response = mapper.readValue(bodyAsJson, AgentDto.class);
		
		assertNotNull(response);
		assertEquals(1L, response.getId());
		assertEquals("agentMODIF@agent.fr", response.getEmail());
		assertEquals("nomAgentMODIF", response.getFullName());
		assertEquals("0632100132", response.getTelephone());
		assertEquals("pwdTailleOk", response.getPwd());
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateUnknownAgent_ShouldReturnNull() throws Exception {
		AgentDto agent=new AgentDto(1950L, "agent@agent.fr", "NomAgent", "0632100132","pwdEntre8et16",
				null);
		
		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.put("/api/agent/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andReturn().getResponse().getContentAsString();
		
		assertTrue(bodyAsJson.isEmpty());
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidAgentWithNullEmail_ShouldReturn4xxStatus() throws Exception {
		AgentDto agent=new AgentDto(5L, null, "NomAgent", "0632100132","pwdEntre8et16",
				null);
		
		mvc.perform(MockMvcRequestBuilders.put("/api/agent/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andDo(print()).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidAgentWithNotValidEmail_ShouldReturn4xxStatus() throws Exception {
		AgentDto agent=new AgentDto(5L, "agentsansarobasagent.fr", "NomAgent", "0632100132","pwdEntre8et16",
				null);
		
		mvc.perform(MockMvcRequestBuilders.put("/api/agent/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')", "Insert into Agent (id,email,pwd,full_name,telephone) values (4,'agent4@agent.fr','pwdTailleOk','nomAgent2','0632100131')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidAgentWithExistingEmail_ShouldReturn4xxStatus() throws Exception {
		AgentDto agent=new AgentDto(5L, "agent4@agent.fr", "NomAgent", "0632100132","pwdEntre8et16",
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/agent/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidAgentWithBlankfullName_ShouldReturn4xxStatus() throws Exception {
		AgentDto agent=new AgentDto(5L, "agent@agent.fr" ,"   ", "0632100132","pwdEntre8et16",
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/agent/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andDo(print()).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidAgentWithStringTelephone_ShouldReturn4xxStatus() throws Exception {
		AgentDto agent=new AgentDto(5L, "agent@agent.fr" ,"nomAgent", "ABCDEFGHIJ","pwdEntre8et16",
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/agent/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andDo(print()).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidAgentWithWrongSizeTelephone_ShouldReturn4xxStatus() throws Exception {
		AgentDto agent=new AgentDto(5L, "agent@agent.fr" ,"nomAgent", "012","pwdEntre8et16",
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/agent/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andDo(print()).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidAgentWithSmallPwd_ShouldReturn4xxStatus() throws Exception {
		AgentDto agent=new AgentDto(5L, "agent@agent.fr" ,"nomAgent", "012","court",
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/agent/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andDo(print()).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidAgentWithLongPwd_ShouldReturn4xxStatus() throws Exception {
		AgentDto agent=new AgentDto(5L, "agent@agent.fr" ,"nomAgent", "012","BeaucoupTropLongOuPresque",
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/agent/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andDo(print()).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidAgentWithBlankPwd_ShouldReturn4xxStatus() throws Exception {
		AgentDto agent=new AgentDto(5L, "agent@agent.fr" ,"nomAgent", "012","          ",
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/agent/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andDo(print()).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = {"Delete From Agent","Insert into Agent (id,email,pwd,full_name,telephone) values (5,'agent@agent.fr','pwdTailleOk','nomAgent','0632100132')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidAgentWithNullPwd_ShouldReturn4xxStatus() throws Exception {
		AgentDto agent=new AgentDto(5L, "agent@agent.fr" ,"nomAgent", "012",null,
				null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/agent/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(agent))).andDo(print()).andExpect(status().is4xxClientError());
	}
	
}
