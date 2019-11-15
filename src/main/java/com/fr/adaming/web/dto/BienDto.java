package com.fr.adaming.web.dto;

import com.fr.adaming.entity.Client;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class BienDto {

	private Long id;
	
	private int prix;
	
	private boolean vendu;
	
	private Client client;

	public BienDto(Long id, int prix, boolean vendu, Client client) {
		super();
		this.id = id;
		this.prix = prix;
		this.vendu = vendu;
		this.client = client;
	}

	public BienDto() {
		super();
	}
	
	public BienDto(int prix, boolean vendu, Client client) {
		this.prix = prix;
		this.vendu = vendu;
		this.client = client;
	}
	
	public BienDto(int prix, boolean vendu) {
		this.prix = prix;
		this.vendu = vendu;
	}
}
