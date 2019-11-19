package com.fr.adaming.web.controller.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fr.adaming.ProjetImmobilierApplicationTests;
import com.fr.adaming.web.dto.AgentDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgentControllerImplTest extends ProjetImmobilierApplicationTests {

	@Test
	public void getAllAgents_shouldReturnEmptyListOfAgents() throws UnsupportedEncodingException, Exception {
		String result = mvc.perform(get("/api/agent/getAll").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		System.out.println("DEBUG DE LA METHODE GETALL : " + result);
	}

	@Test
	public void foundById_AgentNotFound_ShouldReturnNull() throws Exception {
		String result = mvc.perform(get("/api/agent/1/getById")).andExpect(status().is(200)).andReturn().getResponse()
				.getContentAsString();

		assertEquals("", result);
	}

	@Test
	public void SaveValidAgent_shouldReturnSUCCESSFULL() throws Exception {

		AgentDto agent = new AgentDto("agent@agent.fr", "NomAgent", "0632100132","pwdEntre8et16",
				null);

		mvc.perform(MockMvcRequestBuilders.post("/api/agent/save").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(agent))).andExpect(status().isOk());
		
		
	}

}
