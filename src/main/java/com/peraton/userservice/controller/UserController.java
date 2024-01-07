package com.peraton.userservice.controller;

import com.peraton.userservice.entity.Users;
import com.peraton.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Users saveUser(@RequestBody  Users user){
        return userService.saveUser(user);
    }
    @PostMapping("/all")
    public List<Users> saveUsers(@ RequestBody List<Users> users){
        return userService.saveUsers(users);
    }
    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<Users> findUser(@PathVariable("id") Long id){
        return userService.findUser(id);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
         userService.deleteUser(id);
    }
    @DeleteMapping("/all")
    public void deleteAllUsers(){
        userService.deleteAllUsers();
    }

}
