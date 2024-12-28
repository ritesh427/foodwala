package com.pratice.user.service;

import com.pratice.user.DTO.UserDTO;
import com.pratice.user.entity.User;
import com.pratice.user.mapper.UserMapper;
import com.pratice.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<UserDTO> getListOfUsers() {
        List<User> all = userRepo.findAll();
        return all.stream().map(UserMapper.INSTANT::mapUserToUserDto).toList();
    }

    public UserDTO addUser(UserDTO userDTO) {
        User save = userRepo.save(UserMapper.INSTANT.mapUserDtoToUser(userDTO));
        return UserMapper.INSTANT.mapUserToUserDto(save);

    }

    public ResponseEntity<UserDTO> getUserById(int id) {
        Optional<User> user = userRepo.findById(id);
        return user.map(value -> new ResponseEntity<>(UserMapper.INSTANT.mapUserToUserDto(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }
}
