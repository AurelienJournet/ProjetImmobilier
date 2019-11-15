package com.fr.adaming.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.entity.Client;
import com.fr.adaming.repository.ClientRepository;
import com.fr.adaming.service.IClientService;


@Service("clientService")
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClientRepository dao;
	

	@Transactional
	public Client addClient(Client client) {
		
		if(!dao.exists(Example.of(client))){
			return dao.save(client);
		}else
			return null;
	}
	

	public Client findClientById(Long id) {
		
		if(!dao.findById(id).isEmpty())
			return dao.findById(id).get();
		else
			return null;
	}
	

	@Transactional
	public boolean updateClient(Client client){
		
		if(dao.existsById(client.getId())){
			dao.save(client);
			return true;
		}
		else
			return false;
	}
	

	@Transactional
	public boolean deleteClient(Client client) {
		
		if(dao.exists(Example.of(client))) {
			dao.delete(client);
			return true;
		}
		else
			return false;
	}

	public List<Client> findAllClients() {
		return dao.findAll();
	}
	
}
