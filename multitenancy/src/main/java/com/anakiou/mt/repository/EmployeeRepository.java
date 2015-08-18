package com.anakiou.mt.repository;

import org.springframework.data.repository.CrudRepository;

import com.anakiou.mt.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
