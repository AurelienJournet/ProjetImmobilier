package com.fr.adaming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.repository.AgentRepository;
import com.fr.adaming.service.IAgentService;

@Service("agentService")
public class AgentServiceImpl implements IAgentService{

	@Autowired
	private AgentRepository dao;
}
