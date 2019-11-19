package com.fr.adaming.web.converter;

import java.util.ArrayList;
import java.util.List;

import com.fr.adaming.entity.Bien;
import com.fr.adaming.entity.Client;
import com.fr.adaming.web.dto.BienDto;
import com.fr.adaming.web.dto.ClientDto;
/**
 * @author Aurélien
 *
 */
public class ClientConverter {
	
	 public static Client dtoClientToClient(ClientDto dto) {
		 
		 Client client=new Client();
		 
		 client.setEmail(dto.getEmail());
		 client.setFullName(dto.getFullName());
		 client.setTelephone(dto.getTelephone());
		 client.setType(dto.getType());
		 return client;
	 }
	 
	 public static ClientDto clientToDtoClient(Client client) {
		 
		 ClientDto dto=new ClientDto();
		 
		 dto.setEmail(client.getEmail());
		 dto.setFullName(client.getFullName());
		 dto.setTelephone(client.getTelephone());
		 dto.setType(client.getType());
		 return dto;
		 
	 }
	 
	 
		public static List<Client> convertToClientList(List<ClientDto> dtos) {
			List<Client> listClient = new ArrayList<>();
			for(ClientDto dto : dtos) {
				listClient.add(dtoClientToClient(dto));
			}
			return listClient;
		}

		public static List<ClientDto> convertToDtoClientList(List<Client> clients) {
			List<ClientDto> listDtos = new ArrayList<>();
			for(Client client : clients) {
				listDtos.add(clientToDtoClient(client));
			}
			return listDtos;
		}
	 
}
