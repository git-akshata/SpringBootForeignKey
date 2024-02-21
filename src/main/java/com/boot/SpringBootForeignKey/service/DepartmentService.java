package com.boot.SpringBootForeignKey.service;

import com.boot.SpringBootForeignKey.dto.DepartmentDTO;
import com.boot.SpringBootForeignKey.entity.Department;
import com.boot.SpringBootForeignKey.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department saveDepartment(Department department) {

        return  departmentRepository.save(department);
    }

    public Optional<Department> updateDepartment(DepartmentDTO departmentDTO, long id) {
        Optional<Department> department = Optional.ofNullable(departmentRepository.findById(departmentDTO.getDeptId()).orElse(null));
             department.get().setDeptName(departmentDTO.getDeptName());
             department.get().setActive(departmentDTO.isActive());
            return Optional.of(departmentRepository.save(department.get()));
    }

    public Optional<Department> getDeparmentById(long id) {
        return departmentRepository.findById(id);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public void deletedDepartmentById(long id) {
        departmentRepository.deleteById(id);
    }
}
