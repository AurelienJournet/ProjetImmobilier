package com.fr.adaming.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fr.adaming.enumeration.TypeClient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author Aurélien
 *
 */
@Getter @Setter @NoArgsConstructor
public class ClientDto {
	
	@Email
	private String email;
	@NotBlank
	private String fullName;
	
	@Pattern(regexp = "(0|\\+33|0033)[1-9][0-9]{8}")
	private String telephone;
	
	private TypeClient type;
	
	public ClientDto(@NotNull String email, String fullName,String telephone, TypeClient type) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.telephone = telephone;
		this.type = type;
	}
}
