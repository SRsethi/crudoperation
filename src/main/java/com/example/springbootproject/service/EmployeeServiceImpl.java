package com.example.springbootproject.service;

import com.example.springbootproject.entity.EmployeeEntity;
import com.example.springbootproject.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeEntity saveEmployeeData(EmployeeEntity employeeData) {
        return employeeRepo.save(employeeData);
    }

    @Override
    public List<EmployeeEntity> fetchEmployeeList() {
        return (List<EmployeeEntity>) employeeRepo.findAll();
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employee, Integer empId) {
        EmployeeEntity emp
                = employeeRepo.findById(empId)
                .get();

        if (Objects.nonNull(employee.getEmpName())
                && !"".equalsIgnoreCase(
                employee.getEmpName())) {
            emp.setEmpName(
                    employee.getEmpName());
        }
        if (Objects.nonNull(employee.getEmpDept())
                && !"".equalsIgnoreCase(
                employee.getEmpDept())) {
            emp.setEmpDept(
                    employee.getEmpDept());
        }
        return employeeRepo.save(emp);
    }

    @Override
    public void deleteEmployeeById(Integer empId) {
        employeeRepo.deleteById(empId);
    }
}
