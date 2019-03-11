package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserServiceImpl {
    public User saveUser(User user);
    public List<User> getAllUsers();
    public Optional<User> getUserById(int id);
    public void delById(int id);
    public User update(User user,int id);

}
