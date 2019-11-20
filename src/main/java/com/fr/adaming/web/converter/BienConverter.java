package com.fr.adaming.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.fr.adaming.entity.Bien;
import com.fr.adaming.web.dto.BienDto;

/**
 * @author VITTOZ Guillaume
 *
 */
public class BienConverter {

	public static Bien convert(BienDto dto) {
		if (dto == null)
			return null;
		else {
			Bien bien = new Bien();
			bien.setId(dto.getId());
			bien.setPrix(dto.getPrix());
			bien.setVendu(dto.getVendu());
			bien.setClient(dto.getClient());

			return bien;
		}
	}

	public static BienDto convert(Bien bien) {
		if (bien == null)
			return null;
		else {
			BienDto dto = new BienDto();
			dto.setId(bien.getId());
			dto.setPrix(bien.getPrix());
			dto.setVendu(bien.getVendu());
			dto.setClient(bien.getClient());
			return dto;
		}
	}

	public static List<Bien> convertt(List<BienDto> dtos) {
		List<Bien> listBiens = new ArrayList<>();
		for (BienDto dto : dtos) {
			listBiens.add(BienConverter.convert(dto));
		}
		return listBiens;
	}

	public static List<BienDto> convert(List<Bien> biens) {
		List<BienDto> listDtos = new ArrayList<>();
		for (Bien bien : biens) {
			listDtos.add(BienConverter.convert(bien));
		}
		return listDtos;
	}

}
