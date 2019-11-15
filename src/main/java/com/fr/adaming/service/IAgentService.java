package com.fr.adaming.service;

import java.util.Collection;

import com.fr.adaming.entity.Agent;

public interface IAgentService {

	Collection<Agent> getAllAgents();

	Agent getAgentById(Long id);

	Agent saveAgent(Agent agent);

	Agent updateAgent(Agent agent);

	boolean deleteAgent(Long id);
}
