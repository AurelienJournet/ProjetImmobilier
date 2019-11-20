package com.fr.adaming.web.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.service.IBienService;
import com.fr.adaming.web.controller.IBienController;
import com.fr.adaming.web.converter.BienConverter;
import com.fr.adaming.web.dto.BienDto;
/**
 * @author VITTOZ Guillaume
 *
 */
@RestController
public class BienControllerImpl implements IBienController {

	@Autowired
	@Qualifier("bienService")
	private IBienService service;

	@Override
	public List<BienDto> getAllBiens() {
		return BienConverter.convert(service.getAllBiens());

	}

	@Override
	public BienDto getBienById(Long id) {
		return BienConverter.convert(service.getBienById(id));
	}

	@Override
	public BienDto saveBien(@Valid BienDto bienDto) {
		return BienConverter.convert(service.saveBien(BienConverter.convert(bienDto)));
	}

	@Override
	public BienDto updateBien(@Valid BienDto bienDto) {
		return BienConverter.convert(service.updateBien(BienConverter.convert(bienDto)));
	}

	@Override
	public boolean deleteBien(Long id) {
		return service.deleteBien(id);
	}

	@Override
	public BienDto modifEtatVente(@Valid BienDto bienDto) {
		service.getBienById(bienDto.getId()).setVendu(bienDto.getVendu());
		return BienConverter.convert(service.getBienById(bienDto.getId()));
	}
}