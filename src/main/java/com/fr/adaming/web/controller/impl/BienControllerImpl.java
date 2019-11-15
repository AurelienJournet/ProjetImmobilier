package com.fr.adaming.web.controller.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fr.adaming.entity.Bien;
import com.fr.adaming.service.IBienService;
import com.fr.adaming.web.controller.IBienController;
import com.fr.adaming.web.dto.BienDto;
/**
 * @author VITTOZ Guillaume
 *
 */
public class BienControllerImpl implements IBienController {

	@Autowired
	@Qualifier("bienService")
	private IBienService service;

	@Override
	public Collection<Bien> getAllBiens() {
		return service.getAllBiens();

	}

	@Override
	public Bien getBienById(Long id) {
		return service.getBienById(id);
	}

//	@Override
//	public Bien findByPrix(int prix) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Bien saveBien(Bien bien) {
		return service.saveBien(bien);
	}

	@Override
	public Bien updateBien(Bien bien) {
		return service.updateBien(bien);
	}

	@Override
	public boolean deleteBien(Long id) {
		return service.deleteBien(id);
	}

	@Override
	public Bien modifEtatVente(BienDto biendto) {
		service.getBienById(biendto.getId()).setVendu(biendto.getVendu());
		return service.getBienById(biendto.getId());
	}
}
