package com.example.demo.controller;

import java.util.Map;
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

import com.example.demo.domain.User;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

@RestController
@RequestMapping
public class UserController {
	@Autowired 
	UserService userService;
	
    final String USER_URL = "api/v1/user";
    
    @PostMapping(USER_URL)
    public ResponseEntity<Object> createUser(@RequestBody UserDto dto) {
        User response = userService.createUser(dto);
		if(Objects.nonNull(response))
           return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "User Created Successfully", response);
         else
           return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, false, "Something went Wrong", null);
    }

    @GetMapping(USER_URL)
    public ResponseEntity<Object> getUserById(@RequestParam long id){
        User user = userService.getUserById(id);
        if(Objects.nonNull(user)){
            return ResponseHandler.generateResponse(HttpStatus.OK, true, "Data Fetched Successfully", user);
        } else {
            return ResponseHandler.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, false, "Something went Wrong", null);
        }
    }
    
    @PutMapping(USER_URL)
	public ResponseEntity<Object> editUser(@RequestBody UserDto dto) {
		User response = userService.editUser(dto);
		if(Objects.nonNull(response)) {
			return ResponseHandler.generateResponse(HttpStatus.OK, true, "User edited successfully", response);
		}else {
			return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT, false, "No user exists", response);
		}
	}
    
    @DeleteMapping(USER_URL)
	public ResponseEntity<Object> deleteUser(@PathVariable("id") Long id) {
		boolean isDeleted=userService.deleteUser(id);
		if(isDeleted) {
			return ResponseHandler.generateResponse(HttpStatus.OK, isDeleted, "User deleted Successfully", isDeleted);
		}else {
			return ResponseHandler.generateResponse(HttpStatus.NO_CONTENT, isDeleted, "No user exists", isDeleted);
		}
	}
}
