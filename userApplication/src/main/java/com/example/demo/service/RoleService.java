package com.example.demo.service;

import java.util.List;
import java.util.Map;
import com.example.demo.domain.Role;
import com.example.demo.dto.RoleDto;

public interface RoleService {
	Role createRole(RoleDto dto);
	List<Role> getRoles();
	boolean deleteRole(Long id);
}
