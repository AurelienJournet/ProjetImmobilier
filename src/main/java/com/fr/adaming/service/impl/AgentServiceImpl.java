package com.fr.adaming.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.entity.Agent;
import com.fr.adaming.repository.AgentRepository;
import com.fr.adaming.service.IAgentService;
/**
 * @author VITTOZ Guillaume
 *
 */
@Service("agentService")
public class AgentServiceImpl implements IAgentService {


	@Autowired
	private AgentRepository dao;

	@Override
	public Collection<Agent> getAllAgents() {
		return dao.findAll();
	}

	@Override
	public Agent getAgentById(Long id) {
		if (dao.existsById(id))
			return dao.findById(id).get();
		else
			return null;
	}

	@Override
	public Agent saveAgent(Agent agent) {
		
		if (!dao.existsById(agent.getId()))
			return dao.save(agent);
		else
			return null;
	}

	@Override
	public Agent updateAgent(Agent agent) {
		if (dao.existsById(agent.getId()))
			return dao.save(agent);
		else
			return null;
	}

	@Override
	public boolean deleteAgent(Long id) {
		if (dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
