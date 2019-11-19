package com.fr.adaming.web.controller.impl;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.ProjetImmobilierApplicationTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgentControllerImplTest extends ProjetImmobilierApplicationTests{

	@Test
	public void getAllAgents_shouldReturnEmptyListOfAgents() throws UnsupportedEncodingException, Exception {
		String result = mvc.perform(get("/api/agent/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		
		System.out.println("DEBUG DE LA METHODE GETALL : "+ result);
	}
	
	
}
