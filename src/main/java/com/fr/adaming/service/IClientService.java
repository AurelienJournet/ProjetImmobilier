package com.fr.adaming.service;

import java.util.List;
import com.fr.adaming.entity.Client;

/**
 * @author Aurélien Journet
 *
 */
public interface IClientService {
	/**
	 * @param Client à insérer
	 * 
	 * @return Renvoie le client inséré dans la BDD. Renvoie null si le client existe déjà
	 */
	public Client addClient(Client client);

	/**
	 * 
	 * @return Renvoie la liste de tous les clients. Peut être vide.
	 */
	public List<Client> findAllClients();
	/**
	 * @param id du client à trouver
	 * @return Renvoie  le client avec l'id correspondant. Renvoie null si l'id n'existe pas
	 */
	public Client findClientById(Long id);
	/**
	 * @param Client à mettre à jour
	 * @return Renvoie true si la mise à jour est effective. Renvoie false si l'entité n'existait pas (pas de mise à jour)
	 */
	public boolean updateClient(Client client);
	/**
	 * @param Client à supprimer
	 * @return Renvoie true si la suppression est effective. Renvoie false si l'entité n'existait pas (pas de suppression)
	 */
	public boolean deleteClient(Client client);
}
