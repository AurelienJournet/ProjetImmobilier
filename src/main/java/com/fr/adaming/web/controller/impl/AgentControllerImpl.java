package com.fr.adaming.web.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.service.IAgentService;
import com.fr.adaming.web.controller.IAgentController;
import com.fr.adaming.web.converter.AgentConverter;
import com.fr.adaming.web.dto.AgentDto;
/**
 * @author VITTOZ Guillaume
 *
 */
@RestController
public class AgentControllerImpl implements IAgentController {

	@Autowired
	@Qualifier("agentService")
	private IAgentService service;

	@Override
	public List<AgentDto> getAllAgents() {
		return AgentConverter.convert(service.getAllAgents());
	}

	@Override
	public AgentDto getAgentById(Long id) {
		return AgentConverter.convert(service.getAgentById(id));
	}

	@Override
	public AgentDto saveAgent(@Valid AgentDto agentDto) {
		return AgentConverter.convert(service.saveAgent(AgentConverter.convert(agentDto)));
	}

	@Override
	public AgentDto updateAgent(@Valid AgentDto agentDto) {
		return AgentConverter.convert(service.updateAgent(AgentConverter.convert(agentDto)));
	}

	@Override
	public boolean deleteAgent(Long id) {
		return service.deleteAgent(id);
	}
}