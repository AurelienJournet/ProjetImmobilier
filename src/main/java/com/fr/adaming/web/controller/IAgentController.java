package com.fr.adaming.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.web.dto.AgentDto;
/**
 * @author VITTOZ Guillaume
 *
 */
@RequestMapping(path = "api/agent")
public interface IAgentController {

	@GetMapping(path = "/getAll")
	public List<AgentDto> getAllAgents();

	@GetMapping(path = "/{id}/getById")
	public AgentDto getAgentById(@PathVariable Long id);

	@PostMapping(path = "/save", consumes = "application/json")
	public AgentDto saveAgent(@RequestBody AgentDto agentDto);

	@PostMapping(path = "/update")
	public AgentDto updateAgent(@RequestBody AgentDto agentDto);

	@GetMapping(path = "/{id}/delete")
	public boolean deleteAgent(@PathVariable Long id);
}