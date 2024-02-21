package com.boot.SpringBootForeignKey.entity;

import com.boot.SpringBootForeignKey.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "employee")
@EntityListeners(EntityListeners.class)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", unique = true, nullable = false)
    private long empId;

    @Column(name = "emp_code", nullable = false , unique = true, length = 4)
    private String empCode;

    @Column(name = "emp_dob")
    @NotNull //    @Temporal(TemporalType.DATE)
    private Date empDOB;

    @Column(name = "emp_name", length = 35, nullable = false)
    private String empName;

    @Column(name = "emp_gender")
    private GenderEnum empGender;

    @Column(name = "emp_mobile_no")
    private String empMobileNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_dept_id")
    private Department department;

    public Date setEmpDOB(String empDOB) {
        Date date = new Date(1999,02,02);
        return date;
    }
}
