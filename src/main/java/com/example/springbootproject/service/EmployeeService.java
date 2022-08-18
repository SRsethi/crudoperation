package com.example.springbootproject.service;

import com.example.springbootproject.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    // Save operation
    EmployeeEntity saveEmployeeData(EmployeeEntity employeeData);

    // Read operation
    List<EmployeeEntity> fetchEmployeeList();

    // Update operation
    EmployeeEntity updateEmployee(EmployeeEntity employee, Integer empId);

    // Delete operation
    void deleteEmployeeById(Integer empId);
}
