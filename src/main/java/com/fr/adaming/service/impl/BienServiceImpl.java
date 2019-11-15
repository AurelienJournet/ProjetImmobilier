package com.fr.adaming.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.entity.Bien;
import com.fr.adaming.repository.BienRepository;
import com.fr.adaming.service.IBienService;

@Service("bienService")
public class BienServiceImpl implements IBienService {

	@Autowired
	private BienRepository dao;

	public Collection<Bien> getAllBiens() {
		return dao.findAll();
	}

	public Bien getBienById(Long id) {
		if (dao.existsById(id))
			return dao.findById(id).get();
		else
			return null;
	}

	@Transactional
	public Bien modifEtatVente(Long id, Boolean vendu) {
		return dao.modifEtatVente(id, vendu);
	}

	@Override
	public Bien saveBien(Bien bien) {
		if (dao.exists(Example.of(bien))) {
			return null;
		} else {
			return dao.save(bien);
		}
	}

	@Override
	public boolean deleteBien(Long id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Bien updateBien(Bien bien) {
		if (dao.exists(Example.of(bien))) {
			return dao.save(bien);
		} else {
			return null;
		}
	}
}
