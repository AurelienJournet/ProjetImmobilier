package com.fr.adaming.web.controller.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

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
import com.fr.adaming.web.dto.BienDto;
import com.fr.adaming.web.dto.BienDto;
import com.fr.adaming.web.dto.BienDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BienControllerImplTest extends ProjetImmobilierApplicationTests{
 
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	@Test
	@Sql(statements = "Delete From Bien", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void addValidBien_shouldReturnSUCCESSFULL() throws Exception {

		BienDto bien = new BienDto((Integer) 250000, true, null);

		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.post("/api/bien/save").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(bien))).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		BienDto response = mapper.readValue(bodyAsJson, BienDto.class);
		
		assertNotNull(response);
		assertEquals((Integer) 250000, response.getPrix());
		assertEquals(true, response.getVendu());
		assertEquals(null, response.getClient());
	}
	
	@Test
	@Sql(statements = "Delete From Bien", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void addBienWithNegativePrix_shouldReturnStatus400() throws Exception {
		
		BienDto bien=new BienDto(-10, true, null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/bien/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(bien))).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = "Delete From Bien", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void addBienWithNullPrix_shouldReturnStatus400() throws Exception {
		
		BienDto bien=new BienDto(null, true, null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/bien/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(bien))).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = "Delete From Bien", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void addBienWithNullVendu_shouldReturnStatus400() throws Exception {
		
		BienDto bien=new BienDto(210000, null, null);
		
		mvc.perform(MockMvcRequestBuilders.post("/api/bien/add").contentType(MediaType.APPLICATION_JSON).content(asJsonString(bien))).andExpect(status().is4xxClientError());
	}
	
	@Test
	@Sql(statements = {"Delete From Bien","Insert into Bien (id, prix, vendu) VALUES(111, 250000, false)"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void getValidBienById_shouldReturnStatus200() throws Exception {		
		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.get("/api/bien/111/getById").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(200)).andReturn().getResponse().getContentAsString();;
	
		BienDto response = mapper.readValue(bodyAsJson, BienDto.class);
		
		assertNotNull(response);
		assertEquals(111L, response.getId());
		assertEquals(250000, response.getPrix());
		assertEquals(false, response.getVendu());
	
	}
	
	@Test
	public void foundById_BienNotFound_ShouldReturnNull() throws Exception {
		exceptionRule.expect(NestedServletException.class);
		String bodyAsJson = mvc.perform(MockMvcRequestBuilders.get("/api/bien/201/getById").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
		System.out.println("DEBUG response : "+ bodyAsJson);
	}

	
	@Test
	@Sql(statements = "Delete From Bien", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void getAllBiens_shouldReturnEmptyListOfBien() throws UnsupportedEncodingException, Exception {
		String result = mvc.perform(get("/api/bien/getAll").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		System.out.println("DEBUG DE LA METHODE GETALL : " + result);
	}
}
