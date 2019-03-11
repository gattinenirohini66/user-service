package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(userServiceImpl.saveUser(user),HttpStatus.OK);
    }
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<List<User>>(userServiceImpl.getAllUsers(),HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable int id){
        return new ResponseEntity<Optional<User>>(userServiceImpl.getUserById(id),HttpStatus.OK);
    }
    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable int id){
        userServiceImpl.delById(id);
    }
    @PutMapping("/user/{id}")
    public ResponseEntity<Object> update(@RequestBody User user,@PathVariable int id){
        return new ResponseEntity<Object>(userServiceImpl.update(user,id),HttpStatus.OK);
    }
}
