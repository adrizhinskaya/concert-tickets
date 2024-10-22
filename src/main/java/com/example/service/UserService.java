package com.example.service;

import com.example.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void add(String name) {
        userRepository.add(name);
    }

    public String getById(int id) {
        return userRepository.getById(id);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
