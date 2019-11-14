package com.fr.adaming.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fr.adaming.entity.User;
import com.fr.adaming.web.dto.UserDto;

@RequestMapping(path="api/user")
public interface IUserController {
	@PostMapping(path="/add", consumes = "application/json")
	public User AddUser(@RequestBody UserDto dto);
	
	@GetMapping(path="/findAll")
	public List<User> findAllUsers();
	
	@GetMapping(path="/{id}/findById")
	public User findUserById(Long id);
	
	@PostMapping(path="/update", consumes = "application/json")
	public boolean updateUser(@RequestBody UserDto dto);
	
	@PostMapping(path="/delete", consumes = "application/json")
	public boolean deleteUser(@RequestBody UserDto dto);
}
