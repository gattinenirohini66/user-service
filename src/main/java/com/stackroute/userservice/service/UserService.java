package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceImpl {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
       User savedUser = userRepository.save(user);
       return savedUser;
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void delById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user,int id) {
        User userUpdated = userRepository.findById(id).get();
        userUpdated.setAge(user.getAge());
        return userRepository.save(userUpdated);
    }
}
