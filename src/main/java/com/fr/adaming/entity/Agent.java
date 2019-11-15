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
@ToString
public class Agent extends User {
	
	private String pwd;

	private LocalDate dateRecrutement;
	
	@OneToMany(mappedBy = "agentAttribue")
	private List<Client> client;

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public String getFullName() {
		// TODO Auto-generated method stub
		return super.getFullName();
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public int getTelephone() {
		// TODO Auto-generated method stub
		return super.getTelephone();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public void setFullName(String fullName) {
		// TODO Auto-generated method stub
		super.setFullName(fullName);
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public void setTelephone(int telephone) {
		// TODO Auto-generated method stub
		super.setTelephone(telephone);
	}

}
