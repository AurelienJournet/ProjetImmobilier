package com.fr.adaming.web.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * @author VITTOZ Guillaume
 *
 */
@Getter
@Setter
@ToString
public class AgentDto {

	private Long id;

	@Email
	private String email;
	@NotBlank
	private String fullName;
	@Pattern(regexp = "0[1-9][0-9]{8}")
	private String telephone;

	@Pattern(regexp = "^[A-Z][0-9]{8,16}$")
	private String pwd;

	@PastOrPresent
	private LocalDate dateRecrutement;

	public AgentDto(Long id, String email, String fullName, String telephone, String pwd, LocalDate dateRecrutement) {
		super();
		this.id = id;
		this.email = email;
		this.fullName = fullName;
		this.telephone = telephone;
		this.pwd = pwd;
		this.dateRecrutement = dateRecrutement;
	}

	public AgentDto() {
		super();
	}

	public AgentDto(String email, String fullName, String telephone, String pwd, LocalDate dateRecrutement) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.telephone = telephone;
		this.pwd = pwd;
		this.dateRecrutement = dateRecrutement;

	}
}