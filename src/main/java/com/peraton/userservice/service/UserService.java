package com.peraton.userservice.service;

import com.peraton.userservice.entity.Users;
import com.peraton.userservice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<Users> findUser(Long id) {
        return userRepo.findById(id);
    }

    public void deleteUser(Long id) {
         Optional<Users> user = userRepo.findById(id);
         if(user.isPresent()) {userRepo.deleteById(id);System.out.println("Successfully Removed User with ID : "+id);}
         else System.out.println("User not found with ID : "+id);
    }

    public void deleteAllUsers() {
        List<Users> users = userRepo.findAll();
        if(!users.isEmpty())  {userRepo.deleteAll();System.out.println("All Users were removed");}

        else System.out.println("There are no items to delete");
    }

}
