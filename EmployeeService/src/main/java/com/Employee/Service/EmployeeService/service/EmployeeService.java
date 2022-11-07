package com.Employee.Service.EmployeeService.service;


import com.Employee.Service.EmployeeService.model.EmployeeModel;
import com.Employee.Service.EmployeeService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    EmployeeRepository repository;

    public ResponseEntity<EmployeeModel> addUser(EmployeeModel employee){
        try{
            // because of UUID we have to declare it first then assign employee value.
            //EmployeeModel temp = repository.save(new EmployeeModel(UUID.randomUUID(), employee.getName(), employee.getEmail(), employee.getState()));
            EmployeeModel temp = repository.save(employee);
            return new ResponseEntity<>(temp, HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<EmployeeModel> editUser(EmployeeModel employee){
        try{
            // because of UUID we have to declare it first then assign employee value.
            //EmployeeModel temp = repository.save(new EmployeeModel(UUID.randomUUID(), employee.getName(), employee.getEmail(), employee.getState()));
            EmployeeModel emp = repository.findById(employee.getId()).get();
            emp.setName(employee.getName());
            emp.setState(employee.getState());
            EmployeeModel temp = repository.save(emp);
            return new ResponseEntity<>(temp, HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<EmployeeModel> getEmployeeByName(String name){
        return repository.findByName(name);
    }

    public List<EmployeeModel> getEmployee(){
        return repository.findAll();
    }



    public String deleteEmployee(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return "{\"message\":\"Deleted!!!\"}";
        }
        return "{\"Error\":\"Id not found!!!\"}";


    }





}
