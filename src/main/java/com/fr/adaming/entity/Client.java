package com.fr.adaming.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fr.adaming.enumeration.TypeClient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @NoArgsConstructor @ToString
public class Client extends User {
	private TypeClient type;
	
	@OneToMany
	private List<Bien> listeDesBiens;
}
