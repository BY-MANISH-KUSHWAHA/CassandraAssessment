package com.dummy.service.dummyService.controller;



import com.dummy.service.dummyService.model.EmployeeModel;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("employee-service/cassandra/employee")
public interface EmployeeRestConsumer {
    @PostMapping("/add")
    public ResponseEntity<EmployeeModel> addUser(@RequestBody EmployeeModel employee);

    @GetMapping("/allEmployee")
    public List<EmployeeModel> getEmployeee();

    @PutMapping("/update")
    public ResponseEntity<EmployeeModel> editUser(@RequestBody EmployeeModel employee);

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable("id") int id);
}
