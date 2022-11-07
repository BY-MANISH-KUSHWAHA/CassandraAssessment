package com.Employee.Service.EmployeeService.repository;


import com.Employee.Service.EmployeeService.model.EmployeeModel;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeRepository extends CassandraRepository<EmployeeModel, Integer> {

    @AllowFiltering
    List<EmployeeModel> findByName(String name);

    @AllowFiltering
    List<EmployeeModel> findByEmail(String email);

}
