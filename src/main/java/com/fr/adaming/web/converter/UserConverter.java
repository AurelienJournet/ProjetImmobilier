package com.fr.adaming.web.converter;

import com.fr.adaming.entity.User;
import com.fr.adaming.web.dto.UserDto;

public class UserConverter {
	
	public static User DtoUserToUser(UserDto dto) {

		User user = new User();

		user.setEmail(dto.getEmail());
		user.setFullName(dto.getFullName());
		user.setTelephone(dto.getTelephone());
		return user;
	}

	public static UserDto UserToDtoUser(User user) {

		UserDto dto = new UserDto();

		dto.setEmail(user.getEmail());
		dto.setFullName(user.getFullName());
		dto.setTelephone(user.getTelephone());
		return dto;

	}
}
