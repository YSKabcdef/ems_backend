package com.portfolio.employee_management.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.portfolio.employee_management.dto.EmployeeDto;
import com.portfolio.employee_management.entity.Employee;
import com.portfolio.employee_management.exception.ResourceNotFoundException;
import com.portfolio.employee_management.repo.EmployeeRepo;
import com.portfolio.employee_management.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    
    private EmployeeRepo employeeRepo;
    
    private ModelMapper modelMapper;
    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto,Employee.class);
        Employee savedEmployee = employeeRepo.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto findEmployee(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("No Employee with id: " + employeeId));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> findAllEmployee() {
       List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("No Employee with id: " + employeeId));
        EmployeeDto updatingEmployeeDto = modelMapper.map(employee, EmployeeDto.class);
        updatingEmployeeDto.setEmail(employeeDto.getEmail());
        updatingEmployeeDto.setFirstName(employeeDto.getFirstName());
        updatingEmployeeDto.setLastName(employeeDto.getLastName());
        Employee updatedEmployee = modelMapper.map(updatingEmployeeDto, Employee.class);
        employeeRepo.save(updatedEmployee);
        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmplopee(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("No Employee with id: " + employeeId));
        employeeRepo.delete(employee);
    }

}
