package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.entity.Client;

public interface IClientService {

	public Client addClient(Client client);
	public List<Client> findAllClients();
	public Client findClientById(Long id);
	public boolean updateClient(Client client);
	public boolean deleteClient(Client client);
}
