package com.springdatarest.springdatarest.repositories;

import com.springdatarest.springdatarest.entities.Employee;
import org.springframework.data.repository.CrudRepository;

// Spring Data REST
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
