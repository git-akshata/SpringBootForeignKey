package com.boot.SpringBootForeignKey.service;

import com.boot.SpringBootForeignKey.dto.EmployeeDTO;
import com.boot.SpringBootForeignKey.entity.Employee;
import com.boot.SpringBootForeignKey.enums.GenderEnum;
import com.boot.SpringBootForeignKey.repository.DepartmentRepository;
import com.boot.SpringBootForeignKey.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO, employee);
        if(employeeDTO.getEmpGender().equals("Male")){
            employee.setEmpGender(GenderEnum.MALE);
        } else if (employeeDTO.getEmpGender().equals("Female")){
            employee.setEmpGender(GenderEnum.FEMALE);
        } else {
            employee.setEmpGender(GenderEnum.OTHERS);
        }
        employee.setEmpDOB(employeeDTO.getEmpDOB());
        System.out.println(employeeDTO.getEmpDOB());
        employee.setDepartment(departmentRepository.getById(employeeDTO.getDepartment()));
        employee = employeeRepository.save(employee);
        System.out.println(employee);
        return employeeDTO;
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        Optional<Employee> Emp = employeeRepository.findById(employeeDTO.getEmpId());
        Employee employee = Emp.orElse(null);
        BeanUtils.copyProperties(employeeDTO, employee);
        if(employeeDTO.getEmpGender().equals("Male")){
            employee.setEmpGender(GenderEnum.MALE);
        } else if (employeeDTO.getEmpGender().equals("Female")){
            employee.setEmpGender(GenderEnum.FEMALE);
        } else {
            employee.setEmpGender(GenderEnum.OTHERS);
        }
        employee.setDepartment(departmentRepository.getById(employeeDTO.getDepartment()));
        Employee emp2 = employeeRepository.save(employee);
        System.out.println(emp2);
        return employeeDTO;

    }




    public void deleteEmployeeById(long id) {
        System.out.println("Chosen employee id is deleted");
         employeeRepository.deleteById(id);
    }
}
