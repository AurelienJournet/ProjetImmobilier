package com.fr.adaming.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.fr.adaming.entity.Bien;
import com.fr.adaming.service.IBienService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BienServiceImplTest {

	@Autowired
	private IBienService service;

	@Test
	public void getAllBienWithAtLeastOne_shouldReturnListBiens() {

	}

	@Test
	public void getAllBienWithNone_shouldReturnEmptyList() {

	}

	@Test
	@Sql(statements = "truncate bien", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createValidBien_shouldReturnBienWithIdNotNull() {
		Bien bien = new Bien(300000, true);
		service.saveBien(bien);
	}

	@Test
	@Sql(statements = "truncate bien", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createNotValidBien_shouldReturnException() {
		Bien bien = new Bien(null, null);
		service.saveBien(bien);
	}

	@Test
	@Sql(statements = {"truncate bien", "INSERT INTO bien (id, prix, vendu) VALUES(1, 250000, false"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD) 
	public void updateValidBien_shouldReturnBienUpdated() {
		Bien bien = new Bien(1L, 250000, false);
		service.updateBien(bien);
	}

	@Test
	@Sql(statements = {"truncate bien", "INSERT INTO bien (id, prix, vendu) VALUES(2, 500000, true"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateUnknowBien_shouldReturnException() {
		Bien bien = new Bien(1L, 250000, false);
		service.updateBien(bien);
	}

	@Test
	@Sql(statements = {"truncate bien", "INSERT INTO bien (id, prix, vendu) VALUES(1, 200000, false"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void deleteValidBien_shouldReturnTrue() {
		service.deleteBien(1L);
	}

	@Test
	@Sql(statements = {"truncate bien", "INSERT INTO bien (id, prix, vendu) VALUES(2, 200000, false"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void deleteUnknowBien_shouldReturnFalse() {
		service.deleteBien(1L);
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
