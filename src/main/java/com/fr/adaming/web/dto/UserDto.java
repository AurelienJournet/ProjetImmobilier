package com.fr.adaming.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
public class UserDto {

	@NotNull
	private String email;
	private String fullName;
	@Pattern(regexp = "0[1-9][0-9]{8}")
	private int telephone;
	
	public UserDto(@NotNull String email, String fullName, @Pattern(regexp = "0[1-9][0-9]{8}") int telephone) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.telephone = telephone;
	}
}
