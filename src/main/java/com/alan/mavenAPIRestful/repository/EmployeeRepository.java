package com.alan.mavenAPIRestful.repository;

import com.alan.mavenAPIRestful.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee,Long> {

}
