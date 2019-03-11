package com.eir.demo.repository;

import com.eir.demo.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findByLastName(String lastName);
}
