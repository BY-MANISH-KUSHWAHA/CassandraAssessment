package com.authentication.service.authentication.controller;



import com.authentication.service.authentication.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @GetMapping
    public String welcome(){
        return "Welcome";
    }

    @GetMapping("/getToken/{id}")
    public String createToken(@PathVariable("id") int id)  {
        return  "{" +
                "\"message\":"+"\"Token for user:"+id+"\","+
                "\"token\":\""+tokenService.createToken(id)+"\"}";
    }






}
