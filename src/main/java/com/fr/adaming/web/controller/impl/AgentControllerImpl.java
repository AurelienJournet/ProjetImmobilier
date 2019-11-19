package com.fr.adaming.web.controller.impl;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fr.adaming.entity.Agent;
import com.fr.adaming.service.IAgentService;
import com.fr.adaming.web.controller.IAgentController;
import com.fr.adaming.web.converter.AgentConverter;
import com.fr.adaming.web.dto.AgentDto;
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
	public Agent saveAgent(@Valid AgentDto agentDto) {
		return service.saveAgent(AgentConverter.convert(agentDto));
	}

	@Override
	public Agent updateAgent(@Valid AgentDto agentDto) {
		return service.updateAgent(AgentConverter.convert(agentDto));
	}

	@Override
	public boolean deleteAgent(Long id) {
		return service.deleteAgent(id);
	}
}