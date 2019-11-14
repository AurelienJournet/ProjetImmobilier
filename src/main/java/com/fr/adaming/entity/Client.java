package com.fr.adaming.entity;

import javax.persistence.Entity;

import com.fr.adaming.enumeration.TypeClient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @Getter @Setter @NoArgsConstructor @ToString
public class Client extends User {
	private TypeClient type;
}
