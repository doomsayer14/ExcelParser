package com.example.excelparser.repository;

import com.example.excelparser.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> getEmployeeByAge();
    public List<Employee> getEmployeeByName();
    public List<Employee> getEmployeeByNameAndAge();
}
