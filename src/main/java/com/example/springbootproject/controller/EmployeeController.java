package com.example.springbootproject.controller;

import com.example.springbootproject.entity.EmployeeEntity;
import com.example.springbootproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")

    public EmployeeEntity saveEmployeeData(
            @RequestBody EmployeeEntity employee)
    {
        return employeeService.saveEmployeeData(employee);

    }
    @GetMapping("/employee")

    public List<EmployeeEntity> fetchDepartmentList()
    {
        return employeeService.fetchEmployeeList();
    }
    @PutMapping("/employee/{id}")
    public EmployeeEntity
    updateEmployee(@RequestBody EmployeeEntity employee, @PathVariable("id") Integer empId)
    {
        return employeeService.updateEmployee(
                employee, empId);
    }
    @DeleteMapping("/employee/{id}")

    public String deleteEmployeeById(@PathVariable("id") Integer empId) {
        employeeService.deleteEmployeeById(
                empId);
        return "Deleted Successfully";
    }
}
