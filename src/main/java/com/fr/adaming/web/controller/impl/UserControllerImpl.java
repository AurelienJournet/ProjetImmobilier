package com.fr.adaming.web.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.entity.User;
import com.fr.adaming.service.IUserService;
import com.fr.adaming.web.controller.IUserController;
import com.fr.adaming.web.converter.UserConverter;
import com.fr.adaming.web.dto.RegisterDto;
import com.fr.adaming.web.dto.UserDto;

@RestController
public class UserControllerImpl implements IUserController{

	@Autowired
	@Qualifier("userService")
	private IUserService service;

	public User AddUser(@Valid UserDto dto) {
		return service.addUser(UserConverter.DtoUserToUser(dto));
	}

	public List<User> findAllUsers() {
		return service.findAllUsers();
	}

	public User findUserById(Long id) {
		return findUserById(id);
	}

	public boolean updateUser(@Valid UserDto dto) {
		//convertir dto en user
		return service.updateUser(UserConverter.DtoUserToUser(dto));
	}

	public boolean deleteUser(@Valid UserDto dto) {
		//convertir dto en user
		return service.deleteUser(UserConverter.DtoUserToUser(dto));
	}
}
