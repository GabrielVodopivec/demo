package com.example.demo.controllers;

import com.example.demo.dto.response.UsersResponse;
import com.example.demo.dto.user.UserDto;
import com.example.demo.entities.User;
import com.example.demo.services.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IService<UserDto> userService;

    public UserController(IService<UserDto> userService) {
        this.userService = userService;

    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllUsers() {
        UsersResponse response = new UsersResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Solicitud procesada con éxito");
        response.setResult(userService.findAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}