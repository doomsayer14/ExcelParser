package com.example.excelparser.service;

import com.example.excelparser.entity.Employee;
import com.example.excelparser.exception.EmployeeNotFoundException;
import com.example.excelparser.repository.EmployeeRepository;
import lombok.SneakyThrows;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @SneakyThrows
    public Employee getEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            return employeeRepository.getById(id);
        }
        throw new EmployeeNotFoundException(id);
    }

    public List<Employee> getEmployees(String name, Integer age) {
        if (StringUtils.isNotBlank(name) && age == null) {
            return employeeRepository.getEmployeeByName();
        }
        if (StringUtils.isBlank(name) && age != null) {
            return employeeRepository.getEmployeeByAge();
        }
        return employeeRepository.getEmployeeByNameAndAge();
    }

    @SneakyThrows
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @SneakyThrows
    public Employee updateEmployee(Employee employee) {
        Employee newEmployee = new Employee();
                //= employeeRepository.get employee;
        newEmployee.setId(employee.getId());
        if (!employeeRepository.existsById(employee.getId())) {
            throw new EmployeeNotFoundException(employee.getId());
        }
        if (StringUtils.isNotBlank(employee.getName())) {
            newEmployee.setName(employee.getName());
        }
        if (employee.getAge() != null) {
            newEmployee.setAge(employee.getAge());
        }
        return employeeRepository.save(newEmployee);
    }

    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }

}
