package com.example.demo.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	ModelMapper mapper = new ModelMapper();
	
	public User createUser(UserDto dto){
		User user=mapper.map(dto, User.class);
		userRepository.save(user);
		return user;
	}
	
	public User getUserById(long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public User editUser(UserDto dto) {
		    Optional<User> userPresent = userRepository.findById(dto.getId());
		    if (userPresent.isPresent()) {
		        User user = userPresent.get();
		        User supervisor = userRepository.findById(dto.getSupervisorId()).orElse(null);
		        List<String> roles = dto.getRole();

		        if (supervisor != null && roles != null) {
		            user.setSupervisor(supervisor);
		            user.setRoles(roleRepository.findByRoleIn(roles));
		            mapper.map(dto, user);
		            return userRepository.save(user);
		        }
		    }
		    return null;
	}

	public boolean deleteUser(Long id) {
		Optional<User> userPresent = userRepository.findById(id);
		if(userPresent.isPresent()) {
			userRepository.delete(userPresent.get());
			return true;
		}
		return false;		
	}
}
