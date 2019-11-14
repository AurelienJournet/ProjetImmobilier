package com.fr.adaming.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.entity.Client;
import com.fr.adaming.repository.ClientRepository;
import com.fr.adaming.service.IClientService;

/**
 * @author Aurélien Journet
 *
 */
@Service("clientService")
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClientRepository dao;
	
	/**
	 * 
	 * @return Renvoie le client inséré dans la BDD. Renvoie null si le client existe déjà
	 */
	@Transactional
	public Client addClient(Client client) {
		
		if(!dao.exists(Example.of(client))){
			return dao.save(client);
		}else
			return null;
	}
	
	/**
	 * 
	 * @return Renvoie  le client avec l'id correspondant. Renvoie null si l'id n'existe pas
	 */
	public Client findClientById(Long id) {
		
		if(!dao.findById(id).isEmpty())
			return dao.findById(id).get();
		else
			return null;
	}
	
	/**
	 * 
	 * @return Renvoie true si la mise à jour est effective. Renvoie false si l'entité n'existait pas (pas de mise à jour)
	 */
	@Transactional
	public boolean updateClient(Client client){
		
		if(dao.exists(Example.of(client))) {
			dao.save(client);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * 
	 * @return Renvoie true si la suppression est effective. Renvoie false si l'entité n'existait pas (pas de suppression)
	 */
	@Transactional
	public boolean deleteClient(Client client) {
		
		if(dao.exists(Example.of(client))) {
			dao.delete(client);
			return true;
		}
		else
			return false;
	}

	/**
	 * 
	 * @return Renvoie la liste de tous les clients. Peut être vide.
	 */
	public List<Client> findAllClients() {
		return dao.findAll();
	}
	
}
