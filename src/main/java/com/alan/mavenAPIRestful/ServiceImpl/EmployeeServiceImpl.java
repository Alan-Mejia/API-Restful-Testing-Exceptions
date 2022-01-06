package com.alan.mavenAPIRestful.ServiceImpl;

import com.alan.mavenAPIRestful.exception.ResourceNotFoundException;
import com.alan.mavenAPIRestful.model.Employee;
import com.alan.mavenAPIRestful.repository.EmployeeRepository;
import com.alan.mavenAPIRestful.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
//        Optional<Employee> employee = employeeRepository.findById(id);
//        if(employee.isPresent()){
//            return employee.get();
//        }else{
//            throw new ResourceNotFoundException("Employee","Id",id);
//        }

        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //we need to check whether the employee with the given id exists ind DB or not
        Employee existingEmployee1 = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","ID",id));
        existingEmployee1.setFirstName(employee.getFirstName());
        existingEmployee1.setLastName(employee.getLastName());
        existingEmployee1.setEmail(employee.getEmail());
        //finally, save to the DB
        employeeRepository.save(existingEmployee1);
        return existingEmployee1;
    }

    @Override
    public void deleteEmployee(long id) {
        //To validate that the id exists on the DB
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }
}
