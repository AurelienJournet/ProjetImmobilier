package com.fr.adaming.service;

import java.util.Collection;

import com.fr.adaming.entity.Agent;
/**
 * @author VITTOZ Guillaume
 *
 */
public interface IAgentService {

	
	/**
	 * 
	 * @return Renvoie la liste de tous les agents. Peut être vide.
	 */
	Collection<Agent> getAllAgents();

	
	/**
	 * 
	 * @return Renvoie l'agent avec l'id correspondant. Renvoie null si l'id n'existe pas
	 */
	Agent getAgentById(Long id);

	/**
	 * 
	 * @return Renvoie l'agent inséré dans la BDD. Renvoie null si le client existe déjà
	 */
	Agent saveAgent(Agent agent);

	/**
	 * 
	 * @return Renvoie l'agent si la mise à jour est effective. Renvoie null si l'entité n'existait pas (pas de mise à jour)
	 */
	Agent updateAgent(Agent agent);

	/**
	 * 
	 * @return Renvoie true si la suppression est effective. Renvoie false si l'entité n'existait pas (pas de suppression)
	 */
	boolean deleteAgent(Long id);
}
