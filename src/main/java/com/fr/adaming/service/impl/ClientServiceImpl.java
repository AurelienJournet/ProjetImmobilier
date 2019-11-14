package com.fr.adaming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.repository.ClientRepository;

@Service("clientService")
public class ClientServiceImpl {

	@Autowired
	private ClientRepository dao;
}
