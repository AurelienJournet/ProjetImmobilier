package com.fr.adaming.web.dto;

import javax.validation.constraints.NotBlank;

import com.fr.adaming.entity.Client;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * @author VITTOZ Guillaume
 *
 */
@Getter @Setter @ToString
public class BienDto {

	private Long id;
	@NotBlank
	private Integer prix;
	@NotBlank
	private Boolean vendu;
	
	private Client client;

	public BienDto(Long id, Integer prix, Boolean vendu, Client client) {
		super();
		this.id = id;
		this.prix = prix;
		this.vendu = vendu;
		this.client = client;
	}

	public BienDto() {
		super();
	}
	
	public BienDto(Integer prix, Boolean vendu, Client client) {
		this.prix = prix;
		this.vendu = vendu;
		this.client = client;
	}
	
	public BienDto(Integer prix, Boolean vendu) {
		this.prix = prix;
		this.vendu = vendu;
	}

	public BienDto(Long id, Boolean vendu) {
		super();
		this.id = id;
		this.vendu = vendu;
	}
	
	
}


