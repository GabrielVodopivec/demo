package com.example.demo.services;

import com.example.demo.dto.user.UserDto;
import com.example.demo.entities.User;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IService<UserDto> {

    private final CrudRepository<User, Long> userRepository;

    private final ObjectMapper mapper;

    public UserService(CrudRepository<User, Long> userRepository) {
        this.userRepository = userRepository;
        mapper              = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = (List<User>) userRepository.findAll();

        return users.stream()
                    .map(user -> mapper.convertValue(user, UserDto.class))
                    .toList();
    }
}