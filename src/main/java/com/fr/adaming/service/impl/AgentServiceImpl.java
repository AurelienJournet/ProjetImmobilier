package com.fr.adaming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.repository.AgentRepository;

@Service("agentService")
public class AgentServiceImpl {

	@Autowired
	private AgentRepository dao;
}
