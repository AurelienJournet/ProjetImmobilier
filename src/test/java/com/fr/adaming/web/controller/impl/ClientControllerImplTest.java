package com.fr.adaming.web.controller.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fr.adaming.ProjetImmobilierApplicationTests;
import com.fr.adaming.enumeration.TypeClient;
import com.fr.adaming.web.dto.ClientDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientControllerImplTest extends ProjetImmobilierApplicationTests{
		
	@Test
	public void AddValidClient_shouldReturnSUCCESFUL() throws Exception {
		
		ClientDto client=new ClientDto("client@client.fr","NomClient","0600000000",TypeClient.ACHETEUR);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/client/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(client))).andExpect(status().is2xxSuccessful());
	}
	
}