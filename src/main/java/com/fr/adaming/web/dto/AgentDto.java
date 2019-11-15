package com.fr.adaming.web.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
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
	@NotNull
	private String email;

	private String fullName;
	@Pattern(regexp = "0[1-9][0-9]{8}")
	private int telephone;

	@Pattern(regexp = "^[A-Z]{8,16}$")
	private String pwd;

	private LocalDate dateRecrutement;

	public AgentDto(Long id, String email, String fullName, int telephone, String pwd, LocalDate dateRecrutement) {
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

	public AgentDto(String email, String fullName, int telephone, String pwd, LocalDate dateRecrutement) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.telephone = telephone;
		this.pwd = pwd;
		this.dateRecrutement = dateRecrutement;

	}
}
