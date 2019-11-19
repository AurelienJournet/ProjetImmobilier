package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.entity.Bien;

/**
 * @author VITTOZ Guillaume
 *
 */
public interface IBienService {

	
	/**
	 * Method to print all bien
	 * @return All bien in the database
	 */
	List<Bien> getAllBiens();
	
	/**
	 * @param id of bien
	 * @return Bien with this id
	 */
	Bien getBienById (Long id);
	
	
	/**
	 * Save an instance of Bien in the database
	 * @param Object bien
	 * @return Bien saved in the database
	 */
	Bien saveBien(Bien bien);
	
	
	/**
	 * Update the bien in the database
	 * @param Object bien
	 * @return Bien updated in the database
	 */
	Bien updateBien(Bien bien);
	
	
	/**
	 * Delete bien of the database
	 * @param id of bien
	 * @return True if bien is deleted, false if fail
	 */
	boolean deleteBien(Long id);
	
	
	/**
	 * Modify the state of the bien (vendu or not)
	 * @param id of bien
	 * @param vendu state of bien
	 * @return Bien updated in the database
	 */
	Bien modifEtatVente(Long id, Boolean vendu);
}
