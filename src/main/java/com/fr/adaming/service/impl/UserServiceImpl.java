package com.fr.adaming.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fr.adaming.entity.User;
import com.fr.adaming.repository.UserRepository;
import com.fr.adaming.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository dao;

	public User addUser(User user) {
		if(!dao.exists(Example.of(user))) {
			return dao.save(user);
		}
		else
			return null;
	}

	public User findUserById(Long id) {
		if(!dao.findById(id).isEmpty())
			return dao.findById(id).get();
		else
			return null;
	}

	public List<User> findAllUsers() {
		return dao.findAll();
	}

	public boolean updateUser(User user) {
		if(dao.exists(Example.of(user))) {
			dao.save(user);
			return true;
		}
		else
			return false;
	}

	public boolean deleteUser(User user) {
		if(dao.exists(Example.of(user))) {
			dao.delete(user);
			return true;
		}
		else
			return false;
	}
}
