package com.fr.adaming.web.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.Client;
import com.fr.adaming.service.IClientService;
import com.fr.adaming.web.controller.IClientController;
import com.fr.adaming.web.converter.ClientConverter;
import com.fr.adaming.web.dto.ClientDto;
import com.fr.adaming.web.dto.RegisterDto;

@RestController
public class ClientControllerImpl implements IClientController {

		@Autowired
		@Qualifier("clientService")
		private IClientService service;
		
		public Client AddClient(@Valid ClientDto dto) {
			return service.addClient(ClientConverter.DtoClientToClient(dto));
		}

		public List<Client> findAllClients() {
			return service.findAllClients();
		}

		public Client findClientById(Long id) {
			return service.findClientById(id);
		}

		public boolean updateClient(@Valid ClientDto dto) {
			return service.updateClient(ClientConverter.DtoClientToClient(dto));
		}

		public boolean deleteClient(@Valid ClientDto dto) {
			return service.deleteClient(ClientConverter.DtoClientToClient(dto));
		}
}

