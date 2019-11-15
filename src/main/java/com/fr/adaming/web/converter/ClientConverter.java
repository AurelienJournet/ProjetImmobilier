package com.fr.adaming.web.converter;

import com.fr.adaming.entity.Client;
import com.fr.adaming.web.dto.ClientDto;

public class ClientConverter {
	
	 public static Client DtoClientToClient(ClientDto dto) {
		 
		 Client client=new Client();
		 
		 client.setEmail(dto.getEmail());
		 client.setFullName(dto.getFullName());
		 client.setTelephone(dto.getTelephone());
		 client.setType(dto.getType());
		 return client;
	 }
	 
	 public static ClientDto ClientToDtoClient(Client client) {
		 
		 ClientDto dto=new ClientDto();
		 
		 dto.setEmail(client.getEmail());
		 dto.setFullName(client.getFullName());
		 dto.setTelephone(client.getTelephone());
		 dto.setType(client.getType());
		 return dto;
		 
	 }
	 
}
