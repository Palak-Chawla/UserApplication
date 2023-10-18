package com.example.demo.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public Map<String,Object> createUser(UserDto dto){
		Map<String, Object> result = new HashMap<>();
		
		return result;
	}
	
	public User getUserById(long id) {
		return userRepository.findById(id).orElse(null);
	}
}
