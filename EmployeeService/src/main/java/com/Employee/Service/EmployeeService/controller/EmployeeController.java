package com.Employee.Service.EmployeeService.controller;

import com.Employee.Service.EmployeeService.model.EmployeeModel;
import com.Employee.Service.EmployeeService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost/8080")
@RestController
@RequestMapping("/cassandra/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeModel> addUser(@RequestBody EmployeeModel employee){
        System.out.println(employee);
        return service.addUser(employee);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeModel> editUser(@RequestBody EmployeeModel employee){
        System.out.println(employee);
        return service.editUser(employee);
    }

    @GetMapping("/byName/{name}")
    public List<EmployeeModel> getEmployeeByName(@PathVariable("name") String name){
        return service.getEmployeeByName(name);
    }

    @GetMapping("/allEmployee")
    public List<EmployeeModel> getEmployeee(){
        return service.getEmployee();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") int id){

        return service.deleteEmployee(id);
    }


}
