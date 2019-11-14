package com.fr.adaming.web.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.service.IUserService;
import com.fr.adaming.web.controller.IUserController;
import com.fr.adaming.web.dto.RegisterDto;

@RestController
public class UserControllerImpl implements IUserController{

	@Autowired
	@Qualifier("userService")
	private IUserService service;
	
	public void mlkj(@Valid RegisterDto dto) {
		
	}
}
