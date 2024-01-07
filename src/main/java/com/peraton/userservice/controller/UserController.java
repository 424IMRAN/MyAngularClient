package com.peraton.userservice.controller;

import com.peraton.userservice.entity.Users;
import com.peraton.userservice.service.UserService;
import com.peraton.userservice.vo.RestTemplateVo;
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
    @PostMapping("/list")
    public List<Users> saveUsers(@ RequestBody List<Users> users){
        return userService.saveUsers(users);
    }
    @GetMapping("/list")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Users findUser(@PathVariable("id") Long id){
        return userService.findUser(id);
    }
    @PutMapping("/{id}")
    public Users editUserById(@PathVariable("id") Long id, @RequestBody Users user){
        return userService.editUserById(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
         userService.deleteUser(id);
    }
    @DeleteMapping("/list")
    public void deleteAllUsers(){
        userService.deleteAllUsers();
    }

    @GetMapping("/department/{id}")
    public RestTemplateVo getUserWithDepartment(@PathVariable("id") Long id){
        return userService.getUserWithDepartment(id);
    }



}
