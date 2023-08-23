package com.company.User.controller;

import com.company.User.model.User;
import com.company.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class LogInController {
    @Autowired
    private UserRepository userRepository;



    // localhost:8080/login
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public Optional<User> validateUser(@RequestBody User user) {
        Optional<User> loggedInUser = userRepository.findById(user.getEmail());
        if(loggedInUser.isPresent()) {
            if(user.getPassword().equals(loggedInUser.get().getPassword())){
            return loggedInUser;}
            else{
                return Optional.empty();
            }
        }
        else{
        return Optional.empty();
        }
    }
//    @RequestMapping(method = RequestMethod.GET, value = "/users/{email}")
//    public Optional<User> getStudentInfo(@PathVariable String email){
//
//        return userService.getUserInfo(email);
//    }
}
