package com.fr.adaming.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @NoArgsConstructor @ToString
public class Bien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer prix;
	
	@Column(nullable = false)
	private Boolean vendu;
	
	@ManyToOne
	@Column(name = "id_client")
	private Client client;

	public Bien(Integer prix, Boolean vendu) {
		super();
		this.prix = prix;
		this.vendu = vendu;
	}

	public Bien(Long id, Integer prix, Boolean vendu, Client client) {
		super();
		this.id = id;
		this.prix = prix;
		this.vendu = vendu;
		this.client = client;
	}

	public Bien(Integer prix, Boolean vendu, Client client) {
		super();
		this.prix = prix;
		this.vendu = vendu;
		this.client = client;
	}

	public Bien(Long id, Integer prix, Boolean vendu) {
		super();
		this.id = id;
		this.prix = prix;
		this.vendu = vendu;
	}
	
	
	
	
}
