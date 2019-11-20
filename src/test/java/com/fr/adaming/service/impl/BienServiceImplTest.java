package com.fr.adaming.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

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

import com.fr.adaming.entity.Bien;
import com.fr.adaming.service.IBienService;
/**
 * @author VITTOZ Guillaume & JOURNET Aurelien
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BienServiceImplTest {

	@Autowired
	private IBienService service;
	
	private static final Logger logger = Logger.getLogger("com.fr.adaming.service.impl.BienServiceTestImpl");

	@Test
	@Sql(statements = "Delete From Bien", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createValidBien_shouldReturnBienWithIdNotNull() {
		Bien bien = new Bien(300000, true);
		bien = service.saveBien(bien);
		assertEquals(bien.getPrix(), (Integer) 300000);
		assertEquals(bien.getVendu(), true);
		
		logger.debug("TEST CREATE VALID BIEN (DEBUG)");
	}

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	@Sql(statements = "Delete From Bien", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createNotValidBien_shouldThrowException() {
		exceptionRule.expect(DataIntegrityViolationException.class);
		Bien bien = new Bien(null, null);
		service.saveBien(bien);
		
		logger.debug("TEST CREATE NOT VALID BIEN (DEBUG)");
	}

	@Test
	@Sql(statements = {"Delete From Bien", "INSERT INTO bien (id, prix, vendu) VALUES(1, 250000, false)"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void createExistingBien_shouldReturnNull() {
		Bien bien = service.getBienById(1L);
		assertNull(service.saveBien(bien));
		
		logger.debug("TEST CREATE EXISTNG BIEN (DEBUG)");
	}

	@Test
	@Sql(statements = { "Delete From Bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(3, 250000, false)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateValidBien_shouldReturnBienUpdated() {
		Bien bien = service.getBienById(3L);
		bien.setPrix(2850000);
		bien.setVendu(true);
		Bien bienUpdated = service.updateBien(bien);
		assertEquals(bienUpdated.getPrix(), (Integer) 2850000);
		assertEquals(bienUpdated.getVendu(), true);
		
		logger.debug("TEST UPDATE VALID BIEN (DEBUG)");
	}

	@Test
	@Sql(statements = "Delete From Bien", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void updateUnknownBien_shouldReturnNull() {
		Bien bien = new Bien(1L, 250000, false);
		assertNull(service.updateBien(bien));
		
		logger.debug("TEST UPDATE UNKNOWN BIEN (DEBUG)");
	}

	@Test
	@Sql(statements = { "Delete From Bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(1, 200000, false)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void deleteValidBien_shouldReturnTrue() {
		assertTrue(service.deleteBien(1L));
		
		logger.debug("TEST DELETE VALID BIEN (DEBUG)");
	}

	@Test
	@Sql(statements = { "Delete From bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(2, 200000, false)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void deleteUnknownBien_shouldReturnFalse() {
		assertFalse(service.deleteBien(1L));
		
		logger.debug("TEST DELETE UNKNOWN BIEN (DEBUG)");
	}

	@Test
	@Sql(statements = { "Delete From bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(2, 200000, false)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void getValidBienById_shouldReturnThisBien() {
		Bien bien = service.getBienById(2L);
		assertEquals(bien.getPrix(), (Integer) 200000);
		assertEquals(bien.getVendu(), false);
		
		logger.debug("TEST GET LIST OF VALID BIEN (DEBUG)");
	}

	@Test
	@Sql(statements = "Delete From bien")
	public void getUnknownBienById_shouldReturnNull() {
		assertNull(service.getBienById(2L));
		
		logger.debug("TEST GET LIST BUT EMPTY (DEBUG)");
	}

	@Test
	@Sql(statements = { "Delete From bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(1, 250000, false)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void modifEtatVenteValidBien_shouldReturnThisUpdatedBien() {
		Bien bien = service.modifEtatVente(1L, true);
		assertEquals(bien.getVendu(), true);
		assertEquals(bien.getPrix(), (Integer) 250000);
		
		logger.debug("TEST MODIFY STATE OF VALID BIEN (DEBUG)");
	}

	@Test
	@Sql(statements = { "Delete From bien",
			"INSERT INTO bien (id, prix, vendu) VALUES(1, 250000, false)" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	public void modifEtatVenteUnknownBien_shoudThrowException() {
		exceptionRule.expect(NoSuchElementException.class);
		service.modifEtatVente(2L, true);
		
		logger.debug("TEST MODIFY STATE OF UNKNOWN BIEN (DEBUG)");
	}

}
