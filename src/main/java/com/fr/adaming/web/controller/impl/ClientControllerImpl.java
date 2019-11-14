package com.fr.adaming.web.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.service.IClientService;
import com.fr.adaming.web.controller.IClientController;
import com.fr.adaming.web.dto.RegisterDto;

@RestController
public class ClientControllerImpl implements IClientController {

		@Autowired
		@Qualifier("userService")
		private IClientService service;
		
		public void mlkj(@Valid RegisterDto dto) {
			
		}
}

