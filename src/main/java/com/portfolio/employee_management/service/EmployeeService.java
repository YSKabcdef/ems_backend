package com.portfolio.employee_management.service;

import java.util.List;

import com.portfolio.employee_management.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto addEmployee(EmployeeDto employeeDto);

    EmployeeDto findEmployee(Long employeeId);

    List<EmployeeDto> findAllEmployee();

    EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId);

    void deleteEmplopee(Long employeeId);

}
