package com.boot.SpringBootForeignKey.repository;

import com.boot.SpringBootForeignKey.dto.EmployeeDTO;
import com.boot.SpringBootForeignKey.entity.Employee;
import com.boot.SpringBootForeignKey.service.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    Optional<Employee> findById(Long id);
}
