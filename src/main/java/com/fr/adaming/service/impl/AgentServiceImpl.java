package com.fr.adaming.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.entity.Agent;
import com.fr.adaming.repository.AgentRepository;
import com.fr.adaming.service.IAgentService;

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
		return dao.save(agent);
	}

	@Override
	public Agent updateAgent(Agent agent) {
		return dao.save(agent);
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
