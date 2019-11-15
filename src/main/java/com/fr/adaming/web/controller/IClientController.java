package com.fr.adaming.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.entity.Client;
import com.fr.adaming.web.dto.ClientDto;


/**
 * @author Aurélien
 *
 */
@RequestMapping(path = "api/client")
public interface IClientController {

	@PostMapping(path = "/add", consumes = "application/json")
	public Client addClient(@RequestBody ClientDto dto);

	@GetMapping(path = "/findAll")
	public List<Client> findAllClients();

	@GetMapping(path = "/{id}/findById")
	public Client findClientById(Long id);

	@PostMapping(path = "/update", consumes = "application/json")
	public boolean updateClient(@RequestBody ClientDto dto);

	@PostMapping(path = "/delete", consumes = "application/json")
	public boolean deleteClient(@RequestBody ClientDto dto);
}
