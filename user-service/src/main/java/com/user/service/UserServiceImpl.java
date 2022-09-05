package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;

@Service
public class UserServiceImpl implements UserService {

	// fake service
	private List<User> list = List.of(new User(1010L, "Krishna Lagad", "9845785689"),
			new User(1011L, "Aakanksha Yadav", "8976789890"), new User(1012L, "Aishwarya Dhotre", "9098768789"));

	@Override
	public User getUser(Long id) {

		return this.list.stream().filter((user) -> user.getUserId().equals(id)).findAny().orElse(null);
	}

}
