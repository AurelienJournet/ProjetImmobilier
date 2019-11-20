package com.fr.adaming.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.web.dto.ClientDto;


/**
 * @author Aurélien
 *
 */
@RequestMapping(path = "api/client")
public interface IClientController {

	@PostMapping(path = "/add", consumes = "application/json")
	public ClientDto addClient(@RequestBody ClientDto dto);

	@GetMapping(path = "/findAll")
	public List<ClientDto> findAllClients();

	@GetMapping(path = "/{id}/findById")
	public ClientDto findClientById(@PathVariable String id);

	@PostMapping(path = "/update", consumes = "application/json")
	public boolean updateClient(@RequestBody ClientDto dto);

	@PostMapping(path = "/delete", consumes = "application/json")
	public boolean deleteClient(@RequestBody ClientDto dto);
}
