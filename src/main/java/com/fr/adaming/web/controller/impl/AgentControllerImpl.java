package com.fr.adaming.web.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.service.IAgentService;
import com.fr.adaming.web.controller.IAgentController;

@RestController
public class AgentControllerImpl implements IAgentController{

	@Autowired
	@Qualifier("agentService")
	private IAgentService service;
}
