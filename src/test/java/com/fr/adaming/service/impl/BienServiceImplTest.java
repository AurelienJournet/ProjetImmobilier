package com.fr.adaming.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

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

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	@Sql(statements = "truncate bien", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createNotValidBien_shouldReturnException() {
		exceptionRule.expect(DataIntegrityViolationException.class);
		Bien bien = new Bien(null, null);
		service.saveBien(bien);
	}

//	@Test
//	@Sql(statements = {"truncate bien", "INSERT INTO bien (id, prix, vendu) VALUES(1, 250000, false)"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
//	public void createExistingBien_shouldReturnException() {
//		Bien bien = new Bien(1L, 250000, false);
//	}

	@Test
	@Sql(statements = { "truncate bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(1, 250000, false)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidBien_shouldReturnBienUpdated() {
		Bien bien = new Bien(1L, 285000, true);
		service.updateBien(bien);
	}

	@Test
	@Sql(statements = { "truncate bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(2, 500000, true)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateUnknowBien_shouldReturnException() {
		Bien bien = new Bien(1L, 250000, false);
		service.updateBien(bien);
	}

	@Test
	@Sql(statements = { "truncate bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(1, 200000, false)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void deleteValidBien_shouldReturnTrue() {
		assertTrue(service.deleteBien(1L));
	}

	@Test
	@Sql(statements = { "truncate bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(2, 200000, false)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void deleteUnknowBien_shouldReturnFalse() {
		assertFalse(service.deleteBien(1L));
	}

	@Test
	@Sql(statements = { "truncate bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(2, 200000, false)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void getValidBienById_shouldReturnThisBien() {
		service.getBienById(2L);
	}

	@Test
	@Sql(statements = "truncate bien")
	public void getUnknowBienById_shouldReturnNull() {
		assertNull(service.getBienById(2L));
	}

	@Test
	@Sql(statements = { "truncate bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(1, 250000, false)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void modifEtatVenteValidBien_shouldReturnThisUpdatedBien() {
		service.modifEtatVente(1L, true);
	}

	@Test
	@Sql(statements = { "truncate bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(1, 250000, false)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void modifEtatVenteUnknowBien_shoudReturnException() {
		exceptionRule.expect(NoSuchElementException.class);
		service.modifEtatVente(2L, true);
	}

}
