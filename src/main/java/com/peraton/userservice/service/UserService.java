package com.peraton.userservice.service;

import com.peraton.userservice.entity.Users;
import com.peraton.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Users saveUser(Users user) {
        return userRepo.save(user);
    }

    public List<Users> saveUsers(List<Users> users) {
        return userRepo.saveAll(users);
    }
}
