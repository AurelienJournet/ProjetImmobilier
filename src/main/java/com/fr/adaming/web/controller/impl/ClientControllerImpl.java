package com.fr.adaming.web.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.service.IClientService;
import com.fr.adaming.web.controller.IClientController;
import com.fr.adaming.web.converter.ClientConverter;
import com.fr.adaming.web.dto.ClientDto;

@RestController
@CrossOrigin
public class ClientControllerImpl implements IClientController {
	/**
	 * @author Aurélien
	 *
	 */
		@Autowired
		@Qualifier("clientService")
		private IClientService service;
		
		public ClientDto addClient(@Valid ClientDto dto) {
			return ClientConverter.clientToDtoClient(service.addClient(ClientConverter.dtoClientToClient(dto)));
		}

		public List<ClientDto> findAllClients() {
			return ClientConverter.convertToDtoClientList(service.findAllClients());
		}

		public ClientDto findClientById(String id) {
			
			return ClientConverter.clientToDtoClient(service.findClientById(Long.valueOf(id)));
		}

		public boolean updateClient(@Valid ClientDto dto) {
			return service.updateClient(ClientConverter.dtoClientToClient(dto));
		}

		public boolean deleteClient(@Valid ClientDto dto) {
			return service.deleteClient(ClientConverter.dtoClientToClient(dto));
		}
}

