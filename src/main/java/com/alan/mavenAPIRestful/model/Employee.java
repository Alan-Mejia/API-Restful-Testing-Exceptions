package com.alan.mavenAPIRestful.model;


import com.alan.mavenAPIRestful.repository.EmployeeRepository;
import lombok.Data;

import javax.persistence.*;

@Data //Lombok dependency
@Entity(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
}


