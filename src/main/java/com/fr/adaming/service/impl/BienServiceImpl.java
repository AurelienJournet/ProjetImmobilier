package com.fr.adaming.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fr.adaming.entity.Bien;
import com.fr.adaming.repository.BienRepository;
import com.fr.adaming.service.IBienService;
/**
 * @author VITTOZ Guillaume
 *
 */
@Service("bienService")
public class BienServiceImpl implements IBienService {

	@Autowired
	private BienRepository dao;

	public List<Bien> getAllBiens() {
		return dao.findAll();
	}

	public Bien getBienById(Long id) {
		if (dao.existsById(id))
			return dao.findById(id).get();
		else
			return null;
	}

	public Bien modifEtatVente(Long id, Boolean vendu) {
		dao.modifEtatVente(id, vendu);
		return dao.findById(id).get();
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
		if (dao.existsById(bien.getId())) {
			return dao.save(bien);
		} else {
			return null;
		}
	}
}
