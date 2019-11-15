package com.fr.adaming.service;

import java.util.Collection;

import com.fr.adaming.entity.Bien;

public interface IBienService {

	Collection<Bien> getAllBiens();
	
	Bien getBienById (Long id);
	
	Bien saveBien(Bien bien);
	
	Bien updateBien(Bien bien);
	
	boolean deleteBien(Long id);
	
	Bien modifEtatVente(Long id, boolean vendu);
}
