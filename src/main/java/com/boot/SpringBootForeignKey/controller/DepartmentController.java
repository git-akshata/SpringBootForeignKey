package com.boot.SpringBootForeignKey.controller;

import com.boot.SpringBootForeignKey.dto.DepartmentDTO;
import com.boot.SpringBootForeignKey.entity.Department;
import com.boot.SpringBootForeignKey.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
         return ResponseEntity.ok(department);
    }

    @PutMapping("/update")
    public Optional<Department> updateDepartment(@RequestBody DepartmentDTO departmentDTO, long id){
        return departmentService.updateDepartment(departmentDTO,id);
    }

    @GetMapping("/getById/{id}")
    Optional<Department> getDepartmentById(@PathVariable("id") long id){
        return departmentService.getDeparmentById(id);
    }

    @GetMapping("/getAllDepartments")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartmentById(@PathVariable("id") long id){
       departmentService.deletedDepartmentById(id);
    }
}
