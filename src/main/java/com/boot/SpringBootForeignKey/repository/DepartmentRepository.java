package com.boot.SpringBootForeignKey.repository;

import com.boot.SpringBootForeignKey.dto.DepartmentDTO;
import com.boot.SpringBootForeignKey.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>, JpaSpecificationExecutor<Department> {

    //Optional<Department> getDeparmentById(long id);
}
