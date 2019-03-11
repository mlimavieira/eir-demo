package com.eir.demo.controller;


import com.eir.demo.model.Employee;
import com.eir.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> get(@RequestParam(value = "last_name", required = false) String name) {


        return employeeRepository.findByLastName(name);
    }

    @PutMapping("/{id}")
    public Employee put(@PathVariable("id") Integer id, @RequestHeader(value = "key", required = false) String key, @RequestBody EmployeeDto
            dto) {

        Optional<Employee> optEmp = employeeRepository.findById(id);

        if(optEmp.isPresent()) {
            Employee emp = optEmp.get();
            emp.setFirstName(dto.getFirstName());

            employeeRepository.save(emp);

            return emp;

        }

        return null;
    }
}
