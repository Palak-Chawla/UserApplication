package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.Role;
import com.example.demo.dto.RoleDto;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	ModelMapper mapper = new ModelMapper();
	
	public Role createRole(RoleDto dto) {
		Role role=mapper.map(dto, Role.class);
		return roleRepository.save(role);
	}
	
	public Role editRole(RoleDto dto) {
		Optional<Role> rolePresent = roleRepository.findById(dto.getId());
		if(rolePresent.isPresent()) {
			Role role = rolePresent.get();
			mapper.map(dto, role);
			return roleRepository.save(role);
		}
		return null;
	}
	
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}
	
	public boolean deleteRole(Long id) {
		Optional<Role> rolePresent = roleRepository.findById(id);
		if(rolePresent.isPresent()) {
			roleRepository.delete(rolePresent.get());
			return true;
		}
		return false;
	}
}
