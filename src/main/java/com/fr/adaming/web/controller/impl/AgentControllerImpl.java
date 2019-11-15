package com.fr.adaming.web.controller.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fr.adaming.entity.Agent;
import com.fr.adaming.service.IAgentService;
import com.fr.adaming.web.controller.IAgentController;
/**
 * @author VITTOZ Guillaume
 *
 */
public class AgentControllerImpl implements IAgentController {

	@Autowired
	@Qualifier("agentService")
	private IAgentService service;

	@Override
	public Collection<Agent> getAllAgents() {
		return service.getAllAgents();
	}

	@Override
	public Agent getAgentById(Long id) {
		return service.getAgentById(id);
	}

	@Override
	public Agent saveAgent(Agent agent) {
		return service.saveAgent(agent);
	}

	@Override
	public Agent updateAgent(Agent agent) {
		return service.updateAgent(agent);
	}

	@Override
	public boolean deleteAgent(Long id) {
		return service.deleteAgent(id);
	}
}
