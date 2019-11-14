package com.fr.adaming.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.repository.BienRepository;

@Service("bienService")
public class BienServiceImpl {

	@Autowired
	private BienRepository dao;
}
