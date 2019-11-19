package com.fr.adaming.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.web.dto.AgentDto;
/**
 * @author VITTOZ Guillaume
 *
 */
@RestController
@RequestMapping(path = "api/agent")
public interface IAgentController {

	@GetMapping(path = "/getAll")
	List<AgentDto> getAllAgents();

	@GetMapping(path = "/getById")
	AgentDto getAgentById(Long id);

	@PostMapping(path = "/save", consumes = "application/json")
	AgentDto saveAgent(@RequestBody AgentDto agentDto);

	@PutMapping(path = "/update")
	AgentDto updateAgent(AgentDto agentDto);

	@GetMapping(path = "/{id}/delete")
	boolean deleteAgent(Long id);
}