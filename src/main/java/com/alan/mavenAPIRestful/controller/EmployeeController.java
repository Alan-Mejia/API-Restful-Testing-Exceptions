package com.alan.mavenAPIRestful.controller;

import com.alan.mavenAPIRestful.ServiceImpl.EmployeeServiceImpl;
import com.alan.mavenAPIRestful.model.Employee;
import com.alan.mavenAPIRestful.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //build create employee
    @PostMapping("/employee/post")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //build get all employees REST API
    @GetMapping("/employees/getAll")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    //build get employee by ID
    @GetMapping(value = "/employee/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
    }

    //build update employee REST API
    @PutMapping("/employee/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }

    //build delete employee REST API
    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") long id){
        //delete employee from DB
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
    }
}
