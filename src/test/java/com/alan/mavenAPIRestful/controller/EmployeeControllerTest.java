package com.alan.mavenAPIRestful.controller;

import com.alan.mavenAPIRestful.ServiceImpl.EmployeeServiceImpl;
import com.alan.mavenAPIRestful.model.Employee;
import com.alan.mavenAPIRestful.service.EmployeeService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//import static java.util.Collections.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static javafx.beans.binding.Bindings.when;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
class EmployeeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private Employee employee;

    @Before
    public void setup(){
        //A mock MVC has been created
        mockMvc = MockMvcBuilders.standaloneSetup(employeeService).build();
    }

    @Test
    void saveEmployee() {

    }

    @Test
    void getAllEmployees() throws Exception{
        mockMvc.perform(get("/employee/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }

    @Test
    void getEmployeeById() throws Exception{
        mockMvc.perform(get("/employee/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id",Matchers.is(1)))
                .andExpect(jsonPath("$.firstName", Matchers.is("NombreCambiado")))
                .andExpect(jsonPath("$.lastName",Matchers.is("Carrilloz")))
                .andExpect(jsonPath("$.email",Matchers.is("d1515gmail.com")));
    }

    @Test
    void updateEmployee() {
    }

    @Test
    void deleteEmployeeById() {
        //when(employeeService.deleteEmployee(employee)).thenReturn("Employee deleted successfully");

                //mockMvc.perform(get("/employees/getAll").accept(MediaType.APPLICATION_JSON))
                //.andExpect(status().isOk())
                //.andExpect(content().json(""));

    }
}