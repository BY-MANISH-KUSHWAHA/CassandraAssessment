package com.dummy.service.dummyService.controller;


import com.dummy.service.dummyService.model.EmployeeModel;
import com.dummy.service.dummyService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.jayway.jsonpath.JsonPath;


@RestController
@RequestMapping("/consumer")
public class ConsumerController {
//    @Autowired
    UserRestConsumer restConsumer;

//    @Autowired
    AuthRestConsumer authRestConsumer;

//    @Autowired

    EmployeeRestConsumer employeeRestConsumer;

    @Autowired
    public ConsumerController(UserRestConsumer restConsumer, AuthRestConsumer authRestConsumer,EmployeeRestConsumer employeeRestConsumer) {
        this.restConsumer = restConsumer;
        this.authRestConsumer = authRestConsumer;
        this.employeeRestConsumer = employeeRestConsumer;
    }

    @GetMapping("/admin/get-users")
    List<User> getUsers(){
        System.out.println(restConsumer.getClass().getSimpleName());
        return restConsumer.getAll();
    }

    @PostMapping(value = "/admin/signUp" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String savingAUser(@RequestBody User user){
        // token = AuthConsumer.generateToken()
        // return cutsom method
        return restConsumer.savingAUser(user);
    }

    @PostMapping(value = "/admin/login" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String loginAUser(@RequestBody User user){
        String response = restConsumer.loginAUser(user);
        System.out.println(response);
        boolean status = JsonPath.read(response, "$.status");
        if(status==false){
            return response;
        }
        return response.substring(0,response.length()-1)+
                ",\"token\":"+createToken(user.getId())+"}";
    }

    @GetMapping(value="/getToken/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String createToken(@PathVariable("id") int id){
        return authRestConsumer.createToken(id);
    }


    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeModel> addUser(@RequestBody EmployeeModel employee){
        return employeeRestConsumer.addUser(employee);
    }

    @GetMapping("/allEmployee")
    public List<EmployeeModel> getEmployeee(){
        return employeeRestConsumer.getEmployeee();
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<EmployeeModel> editUser(@RequestBody EmployeeModel employee){
        return employeeRestConsumer.editUser(employee);
    }

    @DeleteMapping(value="/deleteEmployee/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteEmployeeById(@PathVariable("id") int id){
        return employeeRestConsumer.deleteEmployeeById(id);
    }


}
