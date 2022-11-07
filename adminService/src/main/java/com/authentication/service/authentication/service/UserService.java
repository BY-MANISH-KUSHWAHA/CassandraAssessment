package com.authentication.service.authentication.service;


import com.authentication.service.authentication.model.User;
import com.authentication.service.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public String loginService(User user){
        String email = user.getEmail();
        String password = user.getPassword();
        List<User> foundUsers =  repository.loginUser(email);
        if(foundUsers.isEmpty()){
            return "{" +
                    "\"message\":"+"\" Authentication Failed !!! (USER NOT FOUND) \","+
                    "\"status\":false"+
                    "}";
        }

        else if(!foundUsers.get(0).getPassword().equals(password)){
            return "{" +
                    "\"message\":"+"\" Password Incorrect !!!\","+
                    "\"status\":false"+
                    "}";
        }
        return "{" +
                "\"message\":"+"\" Successfully Login. \","+
                "\"status\":true"+
                "}";
    }

    public String signUp(User user){
        User savedUser = repository.save(user);
        return "{" +
                "\"message\":"+"\"Successfully Created A User\","+
                "\"data\":"+savedUser+"}";
    }


    public List<User> getAll(){
        return repository.findAll();
    }
}
