package com.fr.adaming.service.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.service.IBienService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BienServiceImplTest {

	@Autowired
	private IBienService service;

	@Test
	public void exempleDeTest() {
		boolean x = true;

		assertTrue(x);
	}
	
	@Test
	public void getAllBienWithAtLeastOne_shouldReturnListBiens() {
		
	}
	
	@Test
	public void getAllBienWithNone_shouldReturnEmptyList() {
		
	}
	
	@Test
	public void createValidBien_shouldReturnBienWithIdNotNull() {
		
	}
	
	@Test
	public void createNotValidBien_shouldReturnException(){
		//Null prix ou Null boolean vendu
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
	
	@Test
	public void modifEtatVenteValidBien_shouldReturnThisUpdatedBien() {
		
	}
	
	@Test
	public void modifEtatVenteUnknowBien_shoudReturnException() {
		
	}




}
