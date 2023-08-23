package com.company.User.controller;

import com.company.User.model.User;
import com.company.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{email}")
    public Optional<User> getStudentInfo(@PathVariable String email){

        return userService.getUserInfo(email);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public User addUser(@RequestBody User user){
        userService.addUser(user);
        return user;
    }
//    @RequestMapping(method = RequestMethod.DELETE,value = "/users/{email}")
//    public Optional<User> deleteUser(@PathVariable String email){
//
//        return userService.deleteUser(email);
//    }

}
