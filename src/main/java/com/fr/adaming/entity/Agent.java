package com.fr.adaming.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Agent extends User {

	
	@Column(nullable=false)
	private String pwd;

	private LocalDate dateRecrutement;

	@OneToMany(mappedBy = "agentAttribue")
	private List<Client> client;
	
	public Agent(String email,String pwd,String fullName,LocalDate dateRecrutement) {
		this.pwd=pwd;
		this.setEmail(email);
		this.setFullName(fullName);
		this.dateRecrutement=dateRecrutement;
	}
	
	public Agent(Long id,String email,String pwd,String fullName,LocalDate dateRecrutement) {
		this.setId(id);
		this.pwd=pwd;
		this.setEmail(email);
		this.setFullName(fullName);
		this.dateRecrutement=dateRecrutement;
	}
}
