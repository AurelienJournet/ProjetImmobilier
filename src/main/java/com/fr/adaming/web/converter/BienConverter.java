package com.fr.adaming.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.fr.adaming.entity.Bien;
import com.fr.adaming.web.dto.BienDto;

public class BienConverter {

	public static Bien convert(BienDto dto) {
		Bien bien = new Bien();
		bien.setId(dto.getId());
		bien.setPrix(dto.getPrix());
		bien.setVendu(dto.isVendu());
		bien.setClient(dto.getClient());
		
		return bien;
	}
	
	public static BienDto convert (Bien bien) {
		BienDto dto = new BienDto();
		dto.setId(bien.getId());
		dto.setPrix(bien.getPrix());
		dto.setVendu(bien.isVendu());
		dto.setClient(bien.getClient());
		return dto;
	}

	public static List<Bien> convertt(List<BienDto> dtos) {
		List<Bien> listBiens = new ArrayList<>();
		for(BienDto dto : dtos) {
			listBiens.add(BienConverter.convert(dto));
		}
		return listBiens;
	}

	public static List<BienDto> convert(List<Bien> biens) {
		List<BienDto> listDtos = new ArrayList<>();
		for(Bien bien : biens) {
			listDtos.add(BienConverter.convert(bien));
		}
		return listDtos;
	}

}
