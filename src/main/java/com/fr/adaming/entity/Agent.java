package com.fr.adaming.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @NoArgsConstructor @ToString
public class Agent extends User{

	private String pwd;
	
	private LocalDate dateRecrutement;
}
