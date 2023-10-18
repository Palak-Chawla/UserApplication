package com.example.demo.service;

import java.util.Map;
import com.example.demo.domain.Role;
import com.example.demo.dto.RoleDto;

public interface RoleService {
	Map<String,Object> createRole(RoleDto dto);
	Role getRoles();
}
