package com.example.excelparser.controller;

import com.example.excelparser.entity.Employee;
import com.example.excelparser.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for employee.
 */

@RestController
@RequestMapping("excel")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "Get an employees",
            notes = "Returns an employee")
    @GetMapping(value = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get an employees",
            notes = "Returns excel file of employees")
    @GetMapping()
    public ResponseEntity<List<Employee>> getEmployees(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") Integer age
    ) {
        return new ResponseEntity<>(employeeService.getEmployees(name, age), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get an employees in pdf",
            notes = "Returns pdf file of employees")
    @GetMapping("/pdf")
    public ResponseEntity<List<Employee>> getEmployeesPdf(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") Integer age
    ) {
        return new ResponseEntity<>(employeeService.getEmployees(name, age), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Post an employee",
            notes = "Returns created employee")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @ApiOperation(value = "Update an employee",
            notes = "Returns updated employee")
    @PutMapping(value = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> updateEmployee(
            @RequestBody Employee employee, @PathVariable Long id) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete an employee")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> deleteMedicine(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
