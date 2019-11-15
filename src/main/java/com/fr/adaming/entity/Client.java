package com.fr.adaming.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fr.adaming.enumeration.TypeClient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @NoArgsConstructor @ToString
public class Client extends User {
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TypeClient type;
	
	@OneToMany(mappedBy = "client")
	private List<Bien> listeDesBiens;
	
	@ManyToOne
	private Agent agentAttribue;
	
	public Client(String email,String fullName,TypeClient type) {
		this.setEmail(email);
		this.setFullName(fullName);
		this.type=type;
	}
}
