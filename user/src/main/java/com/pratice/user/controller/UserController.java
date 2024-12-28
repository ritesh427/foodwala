package com.pratice.user.controller;

import com.pratice.user.DTO.UserDTO;
import com.pratice.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        UserDTO saveUser = userService.addUser(userDTO);
        return new ResponseEntity<>(saveUser,HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> listOfUsers = userService.getListOfUsers();
        return new ResponseEntity<>(listOfUsers, HttpStatus.OK);
    }

    @GetMapping("/userbyid/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

}
