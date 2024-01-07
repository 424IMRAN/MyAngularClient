package com.peraton.userservice.controller;

import com.peraton.userservice.entity.Users;
import com.peraton.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public Users saveUser(@RequestBody  Users user){
        return userService.saveUser(user);
    }
    @PostMapping("/saveUsers")
    public List<Users> saveUsers(@ RequestBody List<Users> users){
        return userService.saveUsers(users);
    }
}
