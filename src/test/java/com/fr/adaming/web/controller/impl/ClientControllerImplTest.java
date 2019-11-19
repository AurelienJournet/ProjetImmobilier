package com.fr.adaming.web.controller.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.fr.adaming.ProjetImmobilierApplicationTests;
import com.fr.adaming.enumeration.TypeClient;
import com.fr.adaming.web.dto.ClientDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientControllerImplTest extends ProjetImmobilierApplicationTests{

	@Test
	@Sql(statements = {"Delete From Client"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void addValidClient_shouldReturnStatus200() throws Exception {
		
		ClientDto client=new ClientDto("client@client.fr","NomClient","0600000000",TypeClient.ACHETEUR);
		
		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.post("/api/client/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(client))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		ClientDto response = mapper.readValue(bodyAsJson, ClientDto.class);
		
		assertNotNull(response);
		assertEquals("client@client.fr", response.getEmail());
		assertEquals("NomClient", response.getFullName());
		assertEquals("0600000000", response.getTelephone());
		assertEquals(TypeClient.ACHETEUR, response.getType());
		
	}
	
	@Test
	public void addClientWithUnvalidEmail_shouldReturnStatus400() throws Exception {
		
		ClientDto client=new ClientDto("clientclient.fr","NomClient","0600000000",TypeClient.ACHETEUR);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/client/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(client))).andExpect(status().is4xxClientError());
	}
	
	@Test
	public void addClientWithUnvalidPhone_shouldReturnStatus400() throws Exception {
		
		ClientDto client=new ClientDto("clientclient","NomClient","+330600",TypeClient.ACHETEUR);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/client/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(client))).andExpect(status().is(400));
	}
	
	@Test
	public void addClientWithBlankName_shouldReturnStatus400() throws Exception {
		
		ClientDto client=new ClientDto("clientclient","   ","+330600",TypeClient.ACHETEUR);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/client/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(client))).andExpect(status().is(400));
	}
	
	@Test
	@Sql(statements = {"Delete From Client","Insert into Client (id,email,full_name,telephone,type) values (200,'client@client.fr','nomClient',0101010101,'ACHETEUR')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void getValidClientById_shouldReturnStatus200() throws Exception {		
		mvc.perform(MockMvcRequestBuilders.get("/api/client/200/findById").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(200));
	
	
	
	}
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	@Sql(statements = {"Delete From Client","Insert into Client (id,email,full_name,telephone,type) values (200,'client@client.fr','nomClient',0101010101,'ACHETEUR')"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void getNotExistingClientById_shouldThrowException() throws Exception {		
		exceptionRule.expect(NestedServletException.class);
		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.get("/api/client/201/findById").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
		System.out.println("DEBUG response : "+ bodyAsJson);
	}
	
	
	
	
	
	
}