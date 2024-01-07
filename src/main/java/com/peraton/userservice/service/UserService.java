package com.peraton.userservice.service;

import com.peraton.userservice.entity.Users;
import com.peraton.userservice.repo.UserRepo;
import com.peraton.userservice.vo.Department;
import com.peraton.userservice.vo.RestTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    RestTemplate restTemplate;

    public Users saveUser(Users user) {
        return userRepo.save(user);
    }

    public List<Users> saveUsers(List<Users> users) {
        return userRepo.saveAll(users);
    }

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public Users findUser(Long id) {
        return userRepo.findUserById(id);
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


    public Users editUserById(Long id, Users newUser) {

        Users oldUser = userRepo.findUserById(id);
        if(oldUser.getId() != null)
        {
            if(newUser.getUserName() != null)
                oldUser.setUserName(newUser.getUserName());
            if(newUser.getEmail() != null)
                oldUser.setEmail(newUser.getEmail());
            if(newUser.getDepartmentId() != null)
                oldUser.setDepartmentId(newUser.getDepartmentId());
            if(newUser.getSex() != null)
                oldUser.setSex(newUser.getSex());
            if(newUser.getDesignation() != null)
                oldUser.setDesignation(newUser.getDesignation());
            if(newUser.getPhoneNumber() != null)
                oldUser.setPhoneNumber(newUser.getPhoneNumber());
        }
        userRepo.save(oldUser);
        return oldUser;
    }

    public RestTemplateVo getUserWithDepartment(Long id) {
        RestTemplateVo vo = new RestTemplateVo();
        Users user = userRepo.findUserById(id);
        Department department = restTemplate.getForObject("http://localhost:9090/departments/"+ user.getDepartmentId(), Department.class);
        vo.setDepartment(department);
        vo.setUsers(user);
        return vo;
    }
}
