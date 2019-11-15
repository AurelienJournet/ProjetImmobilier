package com.fr.adaming.web.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.Agent;

@RestController
@RequestMapping(path = "api/agent")
public interface IAgentController {

	@GetMapping(path = "/getAll")
	Collection<Agent> getAllAgents();

	@GetMapping(path = "/getById")
	Agent getAgentById(Long id);

	@PostMapping(path = "/save")
	Agent saveAgent(@RequestBody Agent agent);

	@PutMapping(path = "/update")
	Agent updateAgent(Agent agent);

	@GetMapping(path = "/{id}/delete")
	boolean deleteAgent(Long id);
}
