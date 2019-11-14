package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.entity.User;

public interface IUserService {
	public User addUser(User user);
	public User findUserById(Long id);
	public List<User> findAllUsers();
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
}
