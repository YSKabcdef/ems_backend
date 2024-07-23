package com.portfolio.employee_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.employee_management.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long>{
    
}
