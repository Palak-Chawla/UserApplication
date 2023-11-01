package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.dto.RoleDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
final String ROLE_URL = "api/v1/role";
    
    @PostMapping(ROLE_URL)
    public ResponseEntity<Object> createRole(@RequestBody RoleDto dto) {
        Role response = roleService.createRole(dto);
		if(Objects.nonNull(response))
           return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "Role Created Successfully", response);
         else
           return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, false, "Something went Wrong", null);
    }
    
    @PutMapping(ROLE_URL)
	public ResponseEntity<Object> editRole(@RequestBody RoleDto dto) {
		Role response = roleService.editRole(dto);
		if(Objects.nonNull(response)) {
			return ResponseHandler.generateResponse(HttpStatus.OK, true, "Role edited successfully", response);
		}else {
			return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT, false, "No role exists", response);
		}
	}
    
    @DeleteMapping(ROLE_URL)
	public ResponseEntity<Object> deleteRole(@PathVariable("id") Long id) {
		boolean isDeleted= roleService.deleteRole(id);
		if(isDeleted) {
			return ResponseHandler.generateResponse(HttpStatus.OK, isDeleted, "Role deleted Successfully", isDeleted);
		}else {
			return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT, isDeleted, "No role exists", isDeleted);
		}
	}

	
}
