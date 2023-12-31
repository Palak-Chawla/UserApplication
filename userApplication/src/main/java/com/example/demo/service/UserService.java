package com.example.demo.service;

import java.util.Map;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;

public interface UserService {
	User createUser(UserDto dto);
	User getUserById(long id);
	User editUser(UserDto dto);
	boolean deleteUser(Long id);
}
