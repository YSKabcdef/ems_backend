package com.portfolio.employee_management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.employee_management.dto.EmployeeDto;
import com.portfolio.employee_management.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto = employeeService.addEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findEmployee(@PathVariable("id") Long employeeId){
        EmployeeDto foundEmployeeDto = employeeService.findEmployee(employeeId);
        return ResponseEntity.ok(foundEmployeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAllEmployee(){
        return ResponseEntity.ok(employeeService.findAllEmployee());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable("id") Long employeeId){
        EmployeeDto updatedEmployeeDto = employeeService.updateEmployee(employeeDto, employeeId);
        return ResponseEntity.ok(updatedEmployeeDto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmplopee(employeeId);
        return new ResponseEntity<>("Employee is deleted successfully",HttpStatus.OK);
    }
}
