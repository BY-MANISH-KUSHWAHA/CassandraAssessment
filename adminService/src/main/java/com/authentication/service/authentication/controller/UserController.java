package com.authentication.service.authentication.controller;


import com.authentication.service.authentication.model.User;
import com.authentication.service.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/signUp" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String savingAUser(@RequestBody User user){
        return userService.signUp(user);
    }

    @PostMapping(value = "/login" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String loginAUser(@RequestBody User user){
        System.out.println(userService.loginService(user));
        return userService.loginService(user);
    }

    @GetMapping(value="/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll(){
        return userService.getAll();
    }


}
