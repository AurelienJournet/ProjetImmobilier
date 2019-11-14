package com.fr.adaming.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fr.adaming.enumeration.TypeClient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ClientDto {
	
	@NotNull
	private String email;
	private String fullName;
	@Pattern(regexp = "0[1-9][0-9]{8}")
	private int telephone;
	private TypeClient type;
	
	public ClientDto(@NotNull String email, String fullName,@Pattern(regexp = "0[1-9][0-9]{8}") int telephone, TypeClient type) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.telephone = telephone;
		this.type = type;
	}
}
