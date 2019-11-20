package com.fr.adaming.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.fr.adaming.entity.Agent;
import com.fr.adaming.web.dto.AgentDto;
/**
 * @author VITTOZ Guillaume
 *
 */
public class AgentConverter {

	public static Agent convert(AgentDto dto) {
		if(dto== null) {
			return null;
		}
		Agent agent = new Agent();
		agent.setId(dto.getId());
		agent.setEmail(dto.getEmail());
		agent.setFullName(dto.getFullName());
		agent.setDateRecrutement(dto.getDateRecrutement());
		agent.setPwd(dto.getPwd());
		agent.setTelephone(dto.getTelephone());
		return agent;
	}

	public static AgentDto convert(Agent agent) {
		if(agent== null) {
			return null;
		}
		AgentDto dto = new AgentDto();
		
		if(agent.getId() != null) {
			dto.setId(agent.getId());
		}
		dto.setId(agent.getId());
		dto.setEmail(agent.getEmail());
		dto.setFullName(agent.getFullName());
		dto.setDateRecrutement(agent.getDateRecrutement());
		dto.setPwd(agent.getPwd());
		dto.setTelephone(agent.getTelephone());
		return dto;
	}

	public static List<Agent> convertt(List<AgentDto> dtos) {
		List<Agent> listAgents = new ArrayList<>();
		for (AgentDto dto : dtos) {
			listAgents.add(AgentConverter.convert(dto));
		}
		return listAgents;
	}

	public static List<AgentDto> convert(List<Agent> agents) {
		List<AgentDto> listDtos = new ArrayList<>();
		for (Agent agent : agents) {
			listDtos.add(AgentConverter.convert(agent));
		}
		return listDtos;
	}
}
