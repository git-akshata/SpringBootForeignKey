package com.boot.SpringBootForeignKey.controller;

import com.boot.SpringBootForeignKey.dto.EmployeeDTO;
import com.boot.SpringBootForeignKey.entity.Employee;
import com.boot.SpringBootForeignKey.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.saveEmployee(employeeDTO);
    }

    @GetMapping("/getEmployee/{id}")
    Optional<Employee> getEmployee(@PathVariable Long id){
        return employeeService.findById(id);
    }
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PutMapping("/updateEmployee")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.updateEmployee(employeeDTO);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public void deleteEmployeeById(@PathVariable("id") long id){
        employeeService.deleteEmployeeById(id);
    }
}
