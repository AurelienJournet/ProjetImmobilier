package com.fr.adaming.web.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.service.IUserService;
import com.fr.adaming.web.controller.IUserController;

@RestController
public class UserControllerImpl implements IUserController{

	@Autowired
	@Qualifier("userService")
	private IUserService service;
}
